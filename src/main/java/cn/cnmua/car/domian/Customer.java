package cn.cnmua.car.domian;

import lombok.Data;

/**
 * @Author hjf
 * @Date 2020/1/2
 * 顾客表，理应从汽车销售处对接数据
 **/
@Data
public class Customer {
    private Integer id;//自增
    private String name;//姓名
    private String phone;//联系电话
    private String provinces;//省
    private String city;//市
    private String county;//区县
    private String address;//详细地址


    public Customer() {
    }

    public Customer(String name, String phone, String provinces, String city, String county, String address) {
        this.name = name;
        this.phone = phone;
        this.provinces = provinces;
        this.city = city;
        this.county = county;
        this.address = address;
    }

    public Customer(Integer id, String name, String phone, String provinces, String city, String county, String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.provinces = provinces;
        this.city = city;
        this.county = county;
        this.address = address;
    }
}
