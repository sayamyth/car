package cn.cnmua.car.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author hjf
 * @Date 2020/2/20
 **/
@Controller
public class UserJumpController {
    /**
     * 用户页面跳转
     */

    //登陆进入用户页面，此处需要加入登陆逻辑
    @RequestMapping("userIndex")
    public String userIndex(){
        return "index-user";
    }

    //此处到配件购商场
    @RequestMapping("userToPartsList")
    public String userToPartsList(){
           return "user/parts-list";
    }
    @RequestMapping("userToPartsDetails")
    public String userToPartsDetails(){
        return "user/parts-details";
    }
    //用户查看4s店
    @RequestMapping("userToShopList")
    public String userToShopList(){
        return "user/shop-list";
    }
    //汽车信息列表
    @RequestMapping("userToCarList")
    public String userToCarList(){
        return "user/car-list";
    }
    //到购物车
    @RequestMapping("userToShopCart")
    public String userToShopCart(){
        return "user/shop-cart";
    }
    //修改购物内容
    @RequestMapping("userShopCartUpdate")
    public String userShopCartUpdate(){
        return "user/shop-cart-update";
    }
    //订单列表
    @RequestMapping("userToOrderList")
    public String userToOrderList(){
        return "user/order-list";
    }
    //跳转到订单详情
    @RequestMapping("userToOrderInfo")
    public String userToOrderInfo(){
        return "user/order-info";
    }
    //信息回馈
    @RequestMapping("userToMessageList")
    public String userToMessageList(){
        return "user/message-list";
    }
    //用户意见反馈
    @RequestMapping("userMessage")
    public String userMessage(){
        return "user/message-order";
    }

}
