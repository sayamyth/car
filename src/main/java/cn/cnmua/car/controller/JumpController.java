package cn.cnmua.car.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * 专门用于页面跳转的控制器
 */

@Controller
public class JumpController {

    //这是登陆界面
    @RequestMapping("/")
    public String index(){
        return "login";
    }
    //会员登陆进入系统
    @RequestMapping("main")
    public String main(){
        return "index";
    }


    /**
     * 顾客信息customer
     */
    //查看顾客信息
    @RequestMapping("getCustomer")
    public String getCustomer(){
        return "customer/customer-list";
    }
    //修改顾客信息
    @RequestMapping("toCustomerUpdate")
    public String toCustomerUpdate(){
        return "customer/customer-update";
    }
    /**
     * 管理员操作店铺
     */
    //管理员进入店铺列表
    @RequestMapping("toShopList")
    public String toShopList(){
        return "shop/shop-list";
    }
    //管理员修改店铺
    @RequestMapping("toShopUpdate")
    public String toShopUpdate(){
        return "shop/shop-update";
    }
    //新增店铺
    @RequestMapping("toShopAdd")
    public String toShopAdd(){
        return "shop/shop-add";
    }
    //添加图片
    @RequestMapping("toShopAddImg")
    public String toShopAddImg(){
        return "shop/shop-addImg";
    }

    /**
     * 汽车配件相关跳转
     */
    @RequestMapping("toPartsList")
    public String toPartsList(){
        return "parts/parts-list";
    }
    //新增配件
    @RequestMapping("toPartsAdd")
    public String toPartsAdd(){
        return "parts/parts-add";
    }
    //修改配件页面
    @RequestMapping("toPartsUpdate")
    public String toPartsUpdate(){
        return "parts/parts-update";
    }
    //添加汽车配件图片
    @RequestMapping("toPartsImgAdd")
    public String toPartsImgAdd(){
        return "parts/parts-addImg";
    }

    //汽车配件类型查询页面
    @RequestMapping("toPartsTypeList")
    public String toPartsTypeList(){
        return "parts/partsType-list";
    }
    //汽车配件类型添加页面
    @RequestMapping("toPartsTypeAdd")
    public String toPartsTypeAdd(){
        return "parts/partsType-add";
    }
    //汽车配件类型修改页面
    @RequestMapping("toPartsTypeUpdate")
    public String toPartsTypeUpdate(){
        return "parts/partsType-update";
    }
    //到订单管理页面
    @RequestMapping("toOrderList")
    public String toOrderList(){
        return "order/order-list";
    }
    //到订单操作页面
    @RequestMapping("toOrderInfo")
    public String toOrderInfo(){
        return "order/order-info";
    }
}
