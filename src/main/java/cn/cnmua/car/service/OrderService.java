package cn.cnmua.car.service;

import cn.cnmua.car.domian.OrderInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import sun.rmi.log.LogInputStream;

import java.util.List;

/**
 *
 * Order订单表的操作接口
 */
public interface OrderService {
    //根据条件查询出所有订单
    List<OrderInfo> getAllByCondition(QueryWrapper queryWrapper);
    //新增订单
    int saveOrder(OrderInfo order);
    //删除订单
    int deleteOrder(String id);
    //修改订单
    int updateOrder(OrderInfo order);
    //按条件查询
    List<OrderInfo> selectOrderByCondition(QueryWrapper queryWrapper);

    //分页且带条件
    Page<OrderInfo> selectOrderByCondition(Page page, QueryWrapper queryWrapper);
    //按条件删除
    int delOrder(QueryWrapper queryWrapper);
}
