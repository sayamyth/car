package cn.cnmua.car.domian;

import lombok.Data;

/**
 * @Author hjf
 * @Date 2019/12/31
 * 汽车配件（例如机油，轮胎等）
 **/
@Data
public class Parts {
    private Integer id;
    private String partsTypeId;
    private String produce;//配件生产厂商
    private String partsName;//配件名称
    private String partsPrice;//配件价格
    private String partsDesc;//配件描述
    private String partsImg;//配件首页展示图片
    private String discount;//商品折扣

    public Parts() {
    }

    public Parts(String partsTypeId, String produce, String partsName, String partsPrice, String partsDesc, String partsImg, String discount) {
        this.partsTypeId = partsTypeId;
        this.produce = produce;
        this.partsName = partsName;
        this.partsPrice = partsPrice;
        this.partsDesc = partsDesc;
        this.partsImg = partsImg;
        this.discount = discount;
    }

    public Parts(Integer id, String partsTypeId, String produce, String partsName, String partsPrice, String partsDesc, String discount) {
        this.id = id;
        this.partsTypeId = partsTypeId;
        this.produce = produce;
        this.partsName = partsName;
        this.partsPrice = partsPrice;
        this.partsDesc = partsDesc;
        this.discount = discount;
    }

    public Parts(Integer id, String partsTypeId, String produce, String partsName, String partsPrice, String partsDesc, String partsImg, String discount) {
        this.id = id;
        this.partsTypeId = partsTypeId;
        this.produce = produce;
        this.partsName = partsName;
        this.partsPrice = partsPrice;
        this.partsDesc = partsDesc;
        this.partsImg = partsImg;
        this.discount = discount;
    }
}
