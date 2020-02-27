package cn.cnmua.car.service.Imp;

import cn.cnmua.car.dao.PartsMapper;
import cn.cnmua.car.domian.Parts;
import cn.cnmua.car.service.PartsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author hjf
 * @Date 2019/12/31
 **/
@Service
public class PartsImp implements PartsService {
    @Autowired
    private PartsMapper mapper;


    @Override
    public Parts selectOneByCondition(QueryWrapper queryWrapper) {
        return mapper.selectOne(queryWrapper);
    }

    @Override
    public List selectPartsAll() {
        return mapper.selectAll();
    }

    @Override
    public int saveParts(Parts parts) {
        return mapper.insert(parts);
    }

    @Override
    public int deletePartsByCondition(QueryWrapper queryWrapper) {
        return mapper.delete(queryWrapper);
    }

    @Override
    public int deletePartsById(String id) {
        return mapper.deleteById(id);
    }

    @Override
    public int updatePartsByCondition(Parts parts, QueryWrapper queryWrapper) {
        return mapper.update(parts,queryWrapper);
    }

    @Override
    public Parts findPartsByCondition(QueryWrapper queryWrapper) {
        return mapper.selectOne(queryWrapper);
    }

    @Override
    public int updatePartsById(Parts parts) {
        return mapper.updateById(parts);
    }

    @Override
    public Parts selectOneById(String id) {
        return mapper.selectById(id);
    }

    @Override
    public Page<Parts> selectPartsByCondition(Page page, QueryWrapper queryWrapper) {
        return (Page<Parts>) mapper.selectPage(page,queryWrapper);
    }
}
