package cn.cnmua.car.service;

import cn.cnmua.car.domian.Apply;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * @Author hjf
 * @Date 2020/1/3
 **/
public interface ApplyService {

    int saveApply(Apply apply);

    int deleteApply(String id);

    int updateApply(Apply apply);


    Page selectApplyWithCondition(Page page, QueryWrapper queryWrapper);
    List<Apply> selectApplyListByCondition(QueryWrapper queryWrapper);
}
