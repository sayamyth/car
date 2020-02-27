package cn.cnmua.car.domian;

import lombok.Data;

/**
 * @Author hjf
 * @Date 2020/1/3
 **/
@Data
public class PartsType {
    private Integer id;
    private String name;

    public PartsType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
