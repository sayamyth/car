package cn.cnmua.car.service.Imp;

import cn.cnmua.car.dao.PartsTypeMapper;
import cn.cnmua.car.domian.Parts;
import cn.cnmua.car.domian.PartsType;
import cn.cnmua.car.service.PartsTypeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartsTypeImp implements PartsTypeService {
    @Autowired
    private PartsTypeMapper mapper;
    @Override
    public int savePartsType(PartsType partsType) {
        return mapper.insert(partsType);
    }

    @Override
    public int deletePartsTypeById(String id) {
        return mapper.deleteById(id);
    }

    @Override
    public int updatePartsTypeById(PartsType partsType) {
        return mapper.updateById(partsType);
    }

    @Override
    public Page selectPartsTypeWithCondition(Page page, QueryWrapper queryWrapper) {
        return (Page) mapper.selectPage(page,queryWrapper);
    }

    @Override
    public PartsType selectPartsTypeOneById(String id) {
        return mapper.selectById(id);
    }
}
