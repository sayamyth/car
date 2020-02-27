package cn.cnmua.car.domian;

import lombok.Data;

@Data
//用户和平台管理员反馈,留言
public class Message {
    private Integer id;
    private String userId;//用户id
    private String shopId;//店铺id
    private String orderNum;//订单号
    private String userMessage;//用户留言
    private String userTime;//用户留言时间
    private String adminMessage;//管理员回复
    private String adminTime;//管理员回复时间

    public Message(Integer id, String userId, String shopId, String orderNum, String userMessage, String userTime, String adminMessage, String adminTime) {
        this.id = id;
        this.userId = userId;
        this.shopId = shopId;
        this.orderNum = orderNum;
        this.userMessage = userMessage;
        this.userTime = userTime;
        this.adminMessage = adminMessage;
        this.adminTime = adminTime;
    }
}
