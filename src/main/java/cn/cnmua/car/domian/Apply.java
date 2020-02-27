package cn.cnmua.car.domian;

import lombok.Data;

/**
 * @Author hjf
 * @Date 2020/1/2
 * 客户申请售后单填写
 **/
@Data
public class Apply {
    private Integer id;
    private String userId;//登陆的id
    private String customerId;//用户详情id
    private String applyTypeId;//申请维修或保养类型
    private String applyDesc;//故障描述

    private String applyTime;//申请时间
    private String shopId;//店铺id
    private String orderNum;//订单号

    private String score;//售后评分
    private String state;//管理员审核状态（0：正在审核，1：审核通过，2：审核失败，3：用户取消）
    private String auditTime;//审核时间


    public Apply(Integer id, String userId, String customerId, String applyTypeId, String applyDesc, String applyTime, String shopId, String orderNum, String score, String state, String auditTime) {
        this.id = id;
        this.userId = userId;
        this.customerId = customerId;
        this.applyTypeId = applyTypeId;
        this.applyDesc = applyDesc;
        this.applyTime = applyTime;
        this.shopId = shopId;
        this.orderNum = orderNum;
        this.score = score;
        this.state = state;
        this.auditTime = auditTime;
    }

    public Apply(Integer id, String userId, String customerId, String applyTypeId, String applyDesc, String applyTime, String shopId, String orderNum, String state) {
        this.id = id;
        this.userId = userId;
        this.customerId = customerId;
        this.applyTypeId = applyTypeId;
        this.applyDesc = applyDesc;
        this.applyTime = applyTime;
        this.shopId = shopId;
        this.orderNum = orderNum;
        this.state = state;
    }
}
