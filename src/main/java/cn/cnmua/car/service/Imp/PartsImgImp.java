package cn.cnmua.car.service.Imp;

import cn.cnmua.car.dao.PartsImgMapper;
import cn.cnmua.car.domian.PartsImg;
import cn.cnmua.car.service.PartsImgService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author hjf
 * @Date 2020/1/6
 **/
@Service
public class PartsImgImp implements PartsImgService {
    @Autowired
    private PartsImgMapper mapper;
    @Override
    public int savePartsImg(PartsImg partsImg) {
        return mapper.insert(partsImg);
    }

    @Override
    public int deletePartImgById(String id) {
        return mapper.deleteById(id);
    }

    @Override
    public int updatePartsImgById(PartsImg partsImg) {
        return mapper.updateById(partsImg);
    }

    @Override
    public Page selectPartsImgWithCondition(Page page, QueryWrapper queryWrapper) {
        return (Page) mapper.selectPage(page,queryWrapper);
    }

    @Override
    public List<PartsImg> selectPartsImgListById(QueryWrapper queryWrapper) {
        return mapper.selectList(queryWrapper);
    }
}
