package cn.cnmua.car.controller;

import cn.cnmua.car.domian.Customer;
import cn.cnmua.car.domian.Msg;
import cn.cnmua.car.service.CustomerService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.org.apache.xerces.internal.impl.dv.xs.IDDV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author hjf
 * @Date 2020/1/7
 * 客户信息表
 **/
@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    //新增客户信息
    @RequestMapping("saveCustomer")
    public Msg saveCustomer(String name, String phone, String provinces,
                            String city, String county, String address){
        Customer customer = new Customer(name,phone,provinces,city,county,address);
        int i = customerService.saveCustomer(customer);
        if (i>0){
            return Msg.success().add("msg","用户信息增加成功");
        }else {
            return Msg.success().add("msg","用户信息增加失败");
        }
    }
    //删除用户信息
    @RequestMapping("deleteCustomerById")
    public Msg deleteCustomerById(String id){
        int i = customerService.deleteCustomerById(id);
        if (i>0){
            return Msg.success().add("msg","用户信息删除成功");
        }else {
            return Msg.success().add("msg","用户信息删除失败");
        }
    }
    //批量删除顾客信息
    @RequestMapping("deleteManyCustomerById")
    public Msg deleteManyCustomerById(String id){
        String []ids = id.split(",");
        int suc=0;
        int fail=0;
        for (int k=0;k<ids.length;k++){
            int i = customerService.deleteCustomerById(ids[k]);
            if (i>0){
                suc++;
            }else {
                fail++;
            }
        }
        return Msg.success().add("msg","共执行"+ids.length+"条,成功:"+suc+"个，失败:"+fail+"个");
    }
    //删除用户信息通过userId
    @RequestMapping("deleteCustomerByuserId")
    public Msg deleteCustomerByuserId(String id){
        /*
        先通过userId查询出customerId,意味这user表和customer表还有一张中间表

        * */
        String customerId = null;
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",customerId);
        int i = customerService.deleteCustomerByCondition(queryWrapper);
        if (i>0){
            return Msg.success().add("msg","用户信息删除成功");
        }else {
            return Msg.success().add("msg","用户信息删除失败");
        }
    }
    //管理员修改用户信息
    @RequestMapping("adminUpdateCustomer")
    public Msg adminUpdateCustomer(Integer id,String phone){
        Customer customer = new Customer();
        customer.setId(id);
        customer.setPhone(phone);
        int i = customerService.updateCustomerById(customer);
        if (i>0){
            return Msg.success().add("msg","用户信息修改成功");
        }else {
            return Msg.success().add("msg","用户信息修改失败");
        }
    }

    //修改用户信息
    @RequestMapping("updateCustomer")
    public Msg updateCustomer(Integer id,String name, String phone, String provinces,
                              String city, String county, String address){
        Customer customer = new Customer(id,name,phone,provinces,city,county,address);
        int i = customerService.updateCustomerById(customer);
        if (i>0){
            return Msg.success().add("msg","用户信息修改成功");
        }else {
            return Msg.success().add("msg","用户信息修改失败");
        }
    }
    //查询用户信息,个人用户查询
    @RequestMapping("selectCustomerByuserId")
    public Msg selectCustomerByuserId(String id){
         /*
        先通过userId查询出customerId,意味这user表和customer表还有一张中间表

        * */
         String customerId = null;
        Customer customer = customerService.selectCustomerByuserId(customerId);
        try {
            customer.getName();
            return Msg.success().add("msg",customer);
        }catch (NullPointerException e){
            return Msg.success().add("msg","用户信息不存在");
        }
    }
    //管理员查询用户信息
    @RequestMapping("selectCustomer")
    public Page selectCustomer(@RequestParam(value = "page", defaultValue = "1") Integer page,@RequestParam(value = "limit", defaultValue = "10") Integer limit,
                               @RequestParam(value = "name", defaultValue = "") String name){
        Page<Customer> page1 = new Page<>(page,limit);
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name",name);
        Page customer = customerService.selectCustomerByCondition(page1, queryWrapper);
        return customer;
    }


}
