package cn.cnmua.car.domian;

import lombok.Data;

/**
 * @Author hjf
 * @Date 2020/1/3
 **/
@Data
public class ShopImg {
    private Integer id;
    private String url;
    private String shopId;

    public ShopImg(Integer id, String url, String shopId) {
        this.id = id;
        this.url = url;
        this.shopId = shopId;
    }
}
