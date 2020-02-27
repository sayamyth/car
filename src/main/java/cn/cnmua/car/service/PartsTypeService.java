package cn.cnmua.car.service;

import cn.cnmua.car.domian.Parts;
import cn.cnmua.car.domian.PartsType;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @Author hjf
 * @Date 2020/1/3
 **/
public interface PartsTypeService {
    int savePartsType(PartsType partsType);

    int deletePartsTypeById(String id);

    int updatePartsTypeById(PartsType partsType);

    Page selectPartsTypeWithCondition(Page page, QueryWrapper queryWrapper);
    PartsType selectPartsTypeOneById(String id);


}
