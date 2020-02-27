package cn.cnmua.car.service.Imp;

import cn.cnmua.car.dao.OrderInfoMapper;
import cn.cnmua.car.domian.OrderInfo;
import cn.cnmua.car.service.OrderService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderImp implements OrderService {
    @Autowired
    private OrderInfoMapper orderMapper;

    @Override
    public List<OrderInfo> getAllByCondition(QueryWrapper queryWrapper) {
        return orderMapper.selectList(queryWrapper);
    }

    @Override
    public int saveOrder(OrderInfo order) {
        return orderMapper.insert(order);
    }

    @Override
    public int deleteOrder(String id) {
        return orderMapper.deleteById(id);
    }

    @Override
    public int updateOrder(OrderInfo order) {
        return orderMapper.updateById(order);
    }

    @Override
    public List<OrderInfo> selectOrderByCondition(QueryWrapper queryWrapper) {
        return orderMapper.selectList(queryWrapper);
    }


    @Override
    public Page<OrderInfo> selectOrderByCondition(Page page, QueryWrapper queryWrapper) {
        return (Page<OrderInfo>) orderMapper.selectPage(page,queryWrapper);
    }

    @Override
    public int delOrder(QueryWrapper queryWrapper) {
        return orderMapper.delete(queryWrapper);
    }
}
