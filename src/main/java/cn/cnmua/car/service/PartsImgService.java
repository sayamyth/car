package cn.cnmua.car.service;

import cn.cnmua.car.domian.PartsImg;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * @Author hjf
 * @Date 2020/1/3
 **/
public interface PartsImgService {
    int savePartsImg(PartsImg partsImg);

    int deletePartImgById(String id);

    int updatePartsImgById(PartsImg partsImg);

    Page selectPartsImgWithCondition(Page page, QueryWrapper queryWrapper);
    List<PartsImg> selectPartsImgListById(QueryWrapper queryWrapper);
}
