package cn.cnmua.car.domian;

import lombok.Data;

/**
 * @Author hjf
 * @Date 2020/1/3
 **/
@Data
public class PartsImg {
    private Integer id;
    private String url;
    private String partsId;

    public PartsImg(Integer id, String url, String partsId) {
        this.id = id;
        this.url = url;
        this.partsId = partsId;
    }
}
