package cn.cnmua.car.dao;

import cn.cnmua.car.domian.Parts;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author hjf
 * @Date 2019/12/31
 **/
public interface PartsMapper extends BaseMapper<Parts> {
    //通过子写的sql查询出汽车配件数据
    @Select("select * from parts")
    public List<Parts> selectAll();
}
