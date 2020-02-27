package cn.cnmua.car.service.Imp;

import cn.cnmua.car.dao.OrdersMapper;
import cn.cnmua.car.domian.Orders;
import cn.cnmua.car.service.OrdersService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author hjf
 * @Date 2020/2/23
 **/
@Service
public class OrdersImp implements OrdersService {
    @Autowired
    private OrdersMapper mapper;
    @Override
    public List<Orders> getByCondition(QueryWrapper queryWrapper) {
        return mapper.selectList(queryWrapper);
    }

    @Override
    public int addOrders(Orders orders) {
        return mapper.insert(orders);
    }

    @Override
    public int delOrders(QueryWrapper queryWrapper) {
        return mapper.delete(queryWrapper);
    }
}
