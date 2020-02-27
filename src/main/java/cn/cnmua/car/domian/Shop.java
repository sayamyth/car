package cn.cnmua.car.domian;

import lombok.Data;

import java.io.Serializable;

@Data
//店铺信息
public class Shop implements Serializable {
    private Integer id;
    private String shopName;//店铺名称
    private String provinces;//省
    private String city;//市
    private String district;//区县
    private String shopAddress;//详细地址
    private String shopPhone;//店铺联系电话
    private String shopImg;//店铺照片
    private String shopDesc;//店铺简介
    private String shopState;//店铺状态
    private String shopMessage;//店铺状态回执信息


    public Shop() {
    }

    public Shop(Integer id, String shopName, String provinces, String city, String district, String shopAddress, String shopPhone, String shopImg, String shopDesc, String shopState, String shopMessage) {
        this.id = id;
        this.shopName = shopName;
        this.provinces = provinces;
        this.city = city;
        this.district = district;
        this.shopAddress = shopAddress;
        this.shopPhone = shopPhone;
        this.shopImg = shopImg;
        this.shopDesc = shopDesc;
        this.shopState = shopState;
        this.shopMessage = shopMessage;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", shopName='" + shopName + '\'' +
                ", provinces='" + provinces + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", shopAddress='" + shopAddress + '\'' +
                ", shopPhone='" + shopPhone + '\'' +
                ", shopImg='" + shopImg + '\'' +
                ", shopDesc='" + shopDesc + '\'' +
                ", shopState='" + shopState + '\'' +
                ", shopMessage='" + shopMessage + '\'' +
                '}';
    }
//    public Shop(String shopName, String provinces, String city, String county, String shopAddress, String shopPhone, String shopDesc) {
//        this.shopName = shopName;
//        this.provinces = provinces;
//        this.city = city;
//        this.county = county;
//        this.shopAddress = shopAddress;
//        this.shopPhone = shopPhone;
//        this.shopDesc = shopDesc;
//    }


}
