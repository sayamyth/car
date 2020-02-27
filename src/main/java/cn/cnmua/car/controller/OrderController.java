package cn.cnmua.car.controller;

import cn.cnmua.car.domian.*;
import cn.cnmua.car.service.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author hjf
 * @Date 2020/2/23
 **/
@RestController
public class OrderController {
    @Autowired
    private PartsService partsService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private ShopCartService shopCartService;
    //添加订单表
    @RequestMapping("orderAdd")
    public Msg orderAdd(String id,String message, HttpServletRequest request){
        System.out.println(id);
        String ids[] = id.split(",");
        HttpSession session = request.getSession();
        User u=(User) session.getAttribute("user");

        Date date = new Date();
        SimpleDateFormat sm = new SimpleDateFormat("yyyyMMddHHmmss");
        String newdate=sm.format(date);
        //这个时间用来下订单的存储
        SimpleDateFormat sm1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=sm1.format(date);
        //uuid生成订单号
        String orderNum = UUID.randomUUID().toString().replace("-", "").substring(0, 5)+newdate;
        //创建order订单
        OrderInfo order = new OrderInfo(0,orderNum,u.getId()+"","处理中",time+"",message);
        int i1 = orderService.saveOrder(order);
        if (i1>0){
            for(int i=0;i<ids.length;i++){
                //根据id获取parts
                QueryWrapper<Parts> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("id",ids[i]);
                Parts parts = partsService.selectOneByCondition(queryWrapper);
                //根据id获取shopCart
                QueryWrapper<ShopCart> queryWrapper1=new QueryWrapper<>();
                queryWrapper1.eq("parts_id",ids[i]);
                queryWrapper1.eq("customer_id",u.getId());
                ShopCart shopCart = shopCartService.selectOneByCondition(queryWrapper1);
                //存储信息到orders
                Orders orders = new Orders(0,parts.getPartsTypeId(),parts.getPartsName(),parts.getPartsPrice(),shopCart.getNum(),"666",orderNum);
                ordersService.addOrders(orders);
                //根据id删除shopCart
//                QueryWrapper<ShopCart> queryWrapper2 = new QueryWrapper<>();
//                queryWrapper2.eq("")
                int i2 = shopCartService.shopCartsDelete(shopCart.getId()+"");
            }
            return Msg.success().add("msg","订单已已提交");
        }else {
            return Msg.success().add("msg","订单提交失败");
        }

    }
    //用户自己查询订单
    @RequestMapping("getOrder")
    public Page userGetOrder(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "limit", defaultValue = "10") Integer limit,HttpServletRequest request){
        Page<OrderInfo> pageInfo = new Page<>(page,limit);
        HttpSession session = request.getSession();
        User u=(User) session.getAttribute("user");
        QueryWrapper<OrderInfo> queryWrapper = new QueryWrapper<>();
        if (!"1".equals(u.getType())){
            queryWrapper
                    .eq("user_id",u.getId())
                    .orderByDesc("id");
        }
        Page<OrderInfo> infoPage = orderService.selectOrderByCondition(pageInfo, queryWrapper);
        return infoPage;
    }
    //获取详细的订单信息
    @RequestMapping("getOrders")
    public List getOrders(String orderNum){
        QueryWrapper<Orders> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("order_num",orderNum);
            List<Orders> orders = ordersService.getByCondition(queryWrapper1);
            return orders;
    }
    //用户取消订单
    @RequestMapping("userCancelOrder")
    public Msg userCancelOrder(String orderNum,HttpServletRequest request){
        QueryWrapper<OrderInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_num",orderNum);
        List<OrderInfo> infos = orderService.selectOrderByCondition(queryWrapper);
        infos.get(0).setState("已取消");
        int i = orderService.updateOrder(infos.get(0));
        if (i>0){
            return Msg.success().add("msg","取消成功");
        }else {
            return Msg.success().add("msg","抱歉出错了");
        }
    }
    @RequestMapping("deleteOrder")
    public Msg deleteOrder(String orderNum){
        QueryWrapper<OrderInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_num",orderNum);
        int i = orderService.delOrder(queryWrapper);
        if (i>0){
            QueryWrapper<Orders> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("order_num",orderNum);
            int i1 = ordersService.delOrders(queryWrapper1);
            return Msg.success().add("msg","订单删除成功");
        }else {
            return Msg.success().add("msg","订单删除失败");
        }
    }
    @RequestMapping("passOrder")
    public Msg passOrder(String orderNum){
        QueryWrapper<OrderInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_num",orderNum);
        List<OrderInfo> infos = orderService.selectOrderByCondition(queryWrapper);
        infos.get(0).setState("审核通过，请及时送车");
        int i = orderService.updateOrder(infos.get(0));
        if (i>0){
            return Msg.success().add("msg","提交成功");
        }else {
            return Msg.success().add("msg","提交失败");
        }
    }
}
