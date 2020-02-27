package cn.cnmua.car.domian;

import lombok.Data;

/**
 * @Author hjf
 * @Date 2020/2/23
 **/
@Data
public class Orders {
    private Integer id;
    private String partsTypeId;
    private String partsName;
    private String partsPrice;
    private String num;
    private String total;
    private String orderNum;

    public Orders() {
    }

    public Orders(Integer id, String partsTypeId, String partsName, String partsPrice, String num, String total, String orderNum) {
        this.id = id;
        this.partsTypeId = partsTypeId;
        this.partsName = partsName;
        this.partsPrice = partsPrice;
        this.num = num;
        this.total = total;
        this.orderNum = orderNum;
    }

    public Orders(String partsTypeId, String partsName, String partsPrice, String num, String total, String orderNum) {
        this.partsTypeId = partsTypeId;
        this.partsName = partsName;
        this.partsPrice = partsPrice;
        this.num = num;
        this.total = total;
        this.orderNum = orderNum;
    }
}
