package cn.cnmua.car.controller;

import cn.cnmua.car.domian.Msg;
import cn.cnmua.car.domian.Parts;
import cn.cnmua.car.domian.ShopCart;
import cn.cnmua.car.domian.User;
import cn.cnmua.car.service.PartsService;
import cn.cnmua.car.service.ShopCartService;
import cn.cnmua.car.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author hjf
 * @Date 2020/2/23
 **/
@RestController
public class ShopCartController {
    @Autowired
    private ShopCartService shopCartService;
    @Autowired
    private PartsService partsService;

    //用户新增商品到购物车
    @RequestMapping("shopCartAdd")
    public Msg shopCartAdd(String id, HttpServletRequest request) {
        //通过session获取用户id
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        ShopCart shopCart = new ShopCart(0,user.getId()+"", id, "1");
        int i = shopCartService.shopCartsAdd(shopCart);
        if (i > 0) {
            return Msg.success().add("msg", "添加成功");
        } else {
            return Msg.success().add("msg", "添加失败");
        }
    }
    //用户查询购物车内容
    @RequestMapping("userFindShopCart")
    public List userFindShopCart(HttpServletRequest request){
        ArrayList arrayList = new ArrayList();
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
//        user.getId();
        //获取购物车里的商品id
        QueryWrapper<ShopCart> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("customer_id",user.getId());
        List<ShopCart> list = shopCartService.selectShopCartByCondition(queryWrapper);
        //通过商品id得到真正的商品信息
        for (int k = 0;k<list.size();k++){
            QueryWrapper<Parts> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("id",list.get(k).getPartsId());
            Parts parts = partsService.findPartsByCondition(queryWrapper1);
            arrayList.add(parts);
        }
        return arrayList;
    }
    //查询一个信息，根据条件查询
    @RequestMapping("findOneShopCarts")
    public ShopCart findOneShopCarts(String id,HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        QueryWrapper<Parts> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("customer_id",user.getId());
        queryWrapper.eq("parts_id",id);
        ShopCart shopCart = shopCartService.selectOneByCondition(queryWrapper);
        return shopCart;
    }
    //删除购物车里一件商品
    @RequestMapping("shopCartDelete")
    public Msg shopCartDelete(String id){
        int i = shopCartService.shopCartsDelete(id);
        if (i>0){
            return Msg.success().add("msg","删除成功");
        }else {
            return Msg.success().add("msg","删除失败");
        }
    }
    //修改购物信息
    @RequestMapping("shopCartsUpdate")
    public Msg shopCartsUpdate(@RequestParam(value = "id") String id, @RequestParam(value = "num") String num, HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        QueryWrapper<Parts> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("customer_id",user.getId());
        queryWrapper.eq("parts_id",id);
        ShopCart shopCart = shopCartService.selectOneByCondition(queryWrapper);
        shopCart.setNum(num);

        //执行修改方法
        int i = shopCartService.shopCartsUpdate(shopCart);
        if (i>0){
            return Msg.success().add("msg","修改成功");
        }else {
            return Msg.success().add("msg","修改失败");
        }
    }
}
