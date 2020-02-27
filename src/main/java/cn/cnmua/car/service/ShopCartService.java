package cn.cnmua.car.service;

import cn.cnmua.car.domian.ShopCart;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.util.List;

/**
 * @Author hjf
 * @Date 2020/2/23
 **/
public interface ShopCartService {
    //根据条件查询一个
    ShopCart selectOneByCondition(QueryWrapper queryWrapper);
    List getAll(String id);
    //添加到购物车
    int shopCartsAdd(ShopCart shopCart);
    //查询购物车
    List<ShopCart> selectShopCartByCondition(QueryWrapper queryWrapper);
    int shopCartsUpdate(ShopCart shopCart);
    int shopCartsDelete(String id);
    int shopCarDeleteByConditon(QueryWrapper queryWrapper);
}
