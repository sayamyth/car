package cn.cnmua.car.service;

import cn.cnmua.car.domian.Apply;
import cn.cnmua.car.domian.ApplyType;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * @Author hjf
 * @Date 2020/1/3
 **/
public interface ApplyTypeService {

    int saveApplyType(ApplyType applyType);

    int deleteAppleTypeById(String id);

    int updateAppleTypeById(ApplyType applyType);

    Page selectAppleTypeByCondition(Page page, QueryWrapper queryWrapper);
    ApplyType selectApplyTypeOneByCondition(QueryWrapper queryWrapper);
    List<Apply> selectApplyList(QueryWrapper queryWrapper);
}
