package cn.cnmua.car.domian;

import lombok.Data;

@Data
//订单信息
public class OrderInfo {
    private Integer id;
    private String orderNum;//订单号
    private String userId;//用户id
    private String state;//订单状态
    private String time;//下单时间
    private String message;//备注留言
    public OrderInfo() {

    }

    public OrderInfo(Integer id, String orderNum, String userId, String state, String time, String message) {
        this.id = id;
        this.orderNum = orderNum;
        this.userId = userId;
        this.state = state;
        this.time = time;
        this.message = message;
    }

    public OrderInfo(String orderNum, String userId, String state, String time, String message) {
        this.orderNum = orderNum;
        this.userId = userId;
        this.state = state;
        this.time = time;
        this.message = message;
    }
}
