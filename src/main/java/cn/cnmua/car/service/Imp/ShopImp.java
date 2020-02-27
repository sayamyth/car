package cn.cnmua.car.service.Imp;

import cn.cnmua.car.dao.ShopMapper;
import cn.cnmua.car.domian.Shop;
import cn.cnmua.car.service.ShopService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopImp implements ShopService {
    @Autowired
    private ShopMapper shopInfoMapper;


    @Override
    public List<Shop> getAll(QueryWrapper queryWrapper) {
        return shopInfoMapper.selectList(queryWrapper);
    }

    @Override
    public int saveShop(Shop shop) {
        return shopInfoMapper.insert(shop);
    }

    @Override
    public int deleteShop(String id) {
        return shopInfoMapper.deleteById(id);
    }

    @Override
    public int updateShop(Shop shopInfo) {
        return shopInfoMapper.updateById(shopInfo);
    }

    @Override
    public Shop findShopByCondition(QueryWrapper queryWrapper) {
        return shopInfoMapper.selectOne(queryWrapper);
    }

    @Override
    public Page<Shop> findShopByConditionWithPage(Page page, QueryWrapper queryWrapper) {
        return (Page<Shop>) shopInfoMapper.selectPage(page,queryWrapper);
    }
}
