package cn.cnmua.car.service.Imp;

import cn.cnmua.car.dao.CustomerMapper;
import cn.cnmua.car.domian.Customer;
import cn.cnmua.car.service.CustomerService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerImp implements CustomerService {
    @Autowired
    private CustomerMapper mapper;
    @Override
    public int saveCustomer(Customer customer) {
        return mapper.insert(customer);
    }

    @Override
    public int deleteCustomerById(String id) {
        return mapper.deleteById(id);
    }

    @Override
    public int deleteCustomerByCondition(QueryWrapper queryWrapper) {
        return mapper.delete(queryWrapper);
    }

    @Override
    public int updateCustomerById(Customer customer) {
        return mapper.updateById(customer);
    }

    @Override
    public Page selectCustomerByCondition(Page page, QueryWrapper queryWrapper) {
        return (Page) mapper.selectPage(page,queryWrapper);
    }

    @Override
    public Customer selectCustomerByuserId(String id) {
        return mapper.selectById(id);
    }
}
