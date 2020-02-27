package cn.cnmua.car.service;

import cn.cnmua.car.domian.Parts;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * @Author hjf
 * @Date 2019/12/31
 * 配件的操作
 **/
public interface PartsService {
    //根据条件查询一个
    Parts selectOneByCondition(QueryWrapper queryWrapper);
    //查询汽车配件所有信息
    List selectPartsAll();

    //保存新品
    int saveParts(Parts parts);
    //删除配件
    int deletePartsByCondition(QueryWrapper queryWrapper);
    //根据id删除
    int deletePartsById(String id);
    //修改记录(根据条件修改)
    int updatePartsByCondition(Parts parts,QueryWrapper queryWrapper);
    //按条件查询
    Parts findPartsByCondition(QueryWrapper queryWrapper);
    //根据id修改
    int updatePartsById(Parts parts);
    //根据id查询数据
    Parts selectOneById(String id);
    //查询配件(可带条件，亦可分页)
    Page<Parts> selectPartsByCondition(Page page, QueryWrapper queryWrapper);
}
