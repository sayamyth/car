package cn.cnmua.car.service.Imp;

import cn.cnmua.car.dao.ApplyMapper;
import cn.cnmua.car.domian.Apply;
import cn.cnmua.car.service.ApplyService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author hjf
 * @Date 2020/1/3
 **/
@Service
public class ApplyImp implements ApplyService {
    @Autowired
    private ApplyMapper mapper;
    @Override
    public int saveApply(Apply apply) {
        return mapper.insert(apply);
    }

    @Override
    public int deleteApply(String id) {
        return mapper.deleteById(id);
    }

    @Override
    public int updateApply(Apply apply) {
        return mapper.updateById(apply);
    }

    @Override
    public Page selectApplyWithCondition(Page page, QueryWrapper queryWrapper) {
        return (Page) mapper.selectPage(page,queryWrapper);
    }

    @Override
    public List<Apply> selectApplyListByCondition(QueryWrapper queryWrapper) {
        return mapper.selectList(queryWrapper);
    }
}
