package cn.cnmua.car.service.Imp;

import cn.cnmua.car.dao.ShopCartMapper;
import cn.cnmua.car.domian.ShopCart;
import cn.cnmua.car.service.ShopCartService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author hjf
 * @Date 2020/2/23
 **/
@Service
public class ShopCartsImp implements ShopCartService {
    @Autowired
    private ShopCartMapper mapper;

    @Override
    public ShopCart selectOneByCondition(QueryWrapper queryWrapper) {
        return mapper.selectOne(queryWrapper);
    }

    @Override
    public List getAll(String id) {
        return mapper.getAll(id);
    }

    @Override
    public int shopCartsAdd(ShopCart shopCart) {
        return mapper.insert(shopCart);
    }

    @Override
    public List<ShopCart> selectShopCartByCondition(QueryWrapper queryWrapper) {
        return mapper.selectList(queryWrapper);
    }

    @Override
    public int shopCartsUpdate(ShopCart shopCart) {
        return mapper.updateById(shopCart);
    }

    @Override
    public int shopCartsDelete(String id) {
        return mapper.deleteById(id);
    }

    @Override
    public int shopCarDeleteByConditon(QueryWrapper queryWrapper) {
        return mapper.delete(queryWrapper);
    }
}
