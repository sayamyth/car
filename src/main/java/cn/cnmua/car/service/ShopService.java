package cn.cnmua.car.service;

import cn.cnmua.car.domian.Shop;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 *
 * shopInfo表操作接口
 */
public interface ShopService {
    //获取全部店铺信息
    List<Shop> getAll(QueryWrapper queryWrapper);
    //新增店铺
    int saveShop(Shop shop);
    //删除电偶
    int deleteShop(String id);
    //修改店铺
    int updateShop(Shop shop);
    //按条件查询
    Shop findShopByCondition(QueryWrapper queryWrapper);

    //分页且带条件
    Page<Shop> findShopByConditionWithPage(Page page, QueryWrapper queryWrapper);
}
