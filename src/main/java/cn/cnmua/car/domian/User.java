package cn.cnmua.car.domian;

import lombok.Data;
import sun.util.resources.ga.LocaleNames_ga;

import java.io.Serializable;

@Data
//用户登陆信息
public class User implements Serializable {
    private long id;
    private String userName;
    private String password;
    private String type;
    public User() {
    }

    public User(long id, String userName, String password, String type) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.type = type;
    }

    public User(String userName, String password, String type) {
        this.userName = userName;
        this.password = password;
        this.type = type;
    }
}
