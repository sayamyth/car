package cn.cnmua.car.dao;

import cn.cnmua.car.domian.ShopCart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author hjf
 * @Date 2020/2/23
 **/
public interface ShopCartMapper extends BaseMapper<ShopCart> {
    @Select("SELECT * FROM shop_cart,parts WHERE shop_cart.parts_id=parts.id AND shop_cart.customer_id=12")
    List getAll(String id);
}
