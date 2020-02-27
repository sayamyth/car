package cn.cnmua.car.service.Imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.cnmua.car.dao.UserMapper;
import cn.cnmua.car.domian.User;
import cn.cnmua.car.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImp implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int saveUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int deleteUser(String id) {
        return userMapper.deleteById(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public User findUserByCondition(QueryWrapper queryWrapper) {
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public Page<User> findUserByConditionWithPage(Page page, QueryWrapper<User> queryWrapper) {
        return (Page<User>) userMapper.selectPage(page,queryWrapper);
    }
}
