package cn.cnmua.car.domian;

import lombok.Data;

/**
 * @Author hjf
 * @Date 2020/2/23
 **/
@Data
public class ShopCart {
    private Integer id;
    private String customerId;
    private String partsId;
    private String num;

    public ShopCart() {
    }

    public ShopCart(Integer id, String customerId, String partsId, String num) {
        this.id = id;
        this.customerId = customerId;
        this.partsId = partsId;
        this.num = num;
    }

    public ShopCart(String customerId, String partsId, String num) {
        this.customerId = customerId;
        this.partsId = partsId;
        this.num = num;
    }
}
