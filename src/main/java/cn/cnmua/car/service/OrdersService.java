package cn.cnmua.car.service;

import cn.cnmua.car.domian.Orders;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.util.List;

/**
 * @Author hjf
 * @Date 2020/2/23
 **/
public interface OrdersService {
    //按条件查询
    List<Orders> getByCondition(QueryWrapper queryWrapper);
    //添加信息
    int addOrders(Orders orders);
    //按条件删除
    int delOrders(QueryWrapper queryWrapper);
}
