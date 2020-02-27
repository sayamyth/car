package cn.cnmua.car.service;

import cn.cnmua.car.domian.Car;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Author hjf
 * @Date 2020/2/19
 **/
public interface CarService {
    //查询汽车近况
    Car selectCarInfo(String id);
    //绑定汽车数据

}
