package cn.cnmua.car.domian;

import lombok.Data;

/**
 * @Author hjf
 * @Date 2020/1/3
 **/
@Data
public class ApplyType {
    private Integer id;
    private String name;

    public ApplyType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
