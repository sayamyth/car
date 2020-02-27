package cn.cnmua.car.service.Imp;

import cn.cnmua.car.dao.ApplyTypeMapper;
import cn.cnmua.car.domian.Apply;
import cn.cnmua.car.domian.ApplyType;
import cn.cnmua.car.service.ApplyTypeService;
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
public class ApplyTypeImp implements ApplyTypeService {
    @Autowired
    private ApplyTypeMapper mapper;
    @Override
    public int saveApplyType(ApplyType applyType) {
        return mapper.insert(applyType);
    }

    @Override
    public int deleteAppleTypeById(String id) {
        return mapper.deleteById(id);
    }

    @Override
    public int updateAppleTypeById(ApplyType applyType) {
        return mapper.updateById(applyType);
    }

    @Override
    public Page selectAppleTypeByCondition(Page page, QueryWrapper queryWrapper) {
        return (Page) mapper.selectPage(page,queryWrapper);
    }

    @Override
    public ApplyType selectApplyTypeOneByCondition(QueryWrapper queryWrapper) {
        return mapper.selectOne(queryWrapper);
    }

    @Override
    public List<Apply> selectApplyList(QueryWrapper queryWrapper) {
        return mapper.selectList(queryWrapper);
    }
}
