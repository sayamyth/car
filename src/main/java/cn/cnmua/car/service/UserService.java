package cn.cnmua.car.service;

import cn.cnmua.car.domian.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * use表操作的接口
 */
public interface UserService {

    //添加新账户
    int saveUser(User user);

    //删除用户
    int deleteUser(String id);

    //修改用户通过id
    int updateUser(User user);

    //根据传入条件查询,这里查询出来的是一个user对象
    User findUserByCondition(QueryWrapper queryWrapper);

    //根据传入条件查询user集合，且可以附带条件，q即为条件
    Page<User> findUserByConditionWithPage(Page page,QueryWrapper<User> queryWrapper);

}
