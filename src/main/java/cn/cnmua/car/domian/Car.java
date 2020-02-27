package cn.cnmua.car.domian;

import lombok.Data;

@Data
//汽车信息，做一个简单介绍
public class Car {
    private long id;
    private String carName;
    private String carDescribe;

    public Car(String carName, String carDescribe) {
        this.carName = carName;
        this.carDescribe = carDescribe;
    }
}
