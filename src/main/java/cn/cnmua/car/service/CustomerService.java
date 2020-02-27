package cn.cnmua.car.service;

import cn.cnmua.car.domian.Customer;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * @Author hjf
 * @Date 2020/1/3
 **/
public interface CustomerService {
    //新增用户信息
    int saveCustomer(Customer customer);
    //删除用户信息
    int deleteCustomerById(String id);
    int deleteCustomerByCondition(QueryWrapper queryWrapper);
    //修改用户信息
    int updateCustomerById(Customer customer);
    //查询用户信息
    Page selectCustomerByCondition(Page page, QueryWrapper queryWrapper);
//    List<Customer> selectCustomerListByCondition(QueryWrapper queryWrapper);
    Customer selectCustomerByuserId(String id);
}
