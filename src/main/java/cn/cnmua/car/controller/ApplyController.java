package cn.cnmua.car.controller;

import cn.cnmua.car.domian.Apply;
import cn.cnmua.car.domian.ApplyType;
import cn.cnmua.car.domian.Msg;
import cn.cnmua.car.service.ApplyService;
import cn.cnmua.car.service.ApplyTypeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author hjf
 * @Date 2020/1/6
 * 未完待续。。。
 **/
@RestController
public class ApplyController {
    @Autowired
    private ApplyService applyService;
    @Autowired
    private ApplyTypeService applyTypeService;
    //增加新保养项目
    @RequestMapping("saveApply")
    public Msg saveApply(String userId, String customerId, String applyTypeId, String applyDesc, String shopId, String orderNum){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD : HH:mm:ss");
        String format = sdf.format(date);
        Apply apply = new Apply(0,userId,customerId,applyTypeId,applyDesc,format,shopId,orderNum,"0");
        int i = applyService.saveApply(apply);
        if (i>0){
            return Msg.success().add("msg","单据已提交,等候审核!");
        }else {
            return Msg.success().add("msg","单据提交失败!");
        }
    }
    //删除保养项目
    @RequestMapping("deleteApply")
    public Msg deleteApply(String id){
        int i = applyService.deleteApply(id);
        if (i>0){
            return Msg.success().add("msg","删除成功");
        }else {
            return Msg.success().add("msg","删除失败");
        }
    }
    //查询保养单
    @RequestMapping("selectApplyByUserId")
    public List<Apply> selectApplyByUserId(String userId){
        QueryWrapper<Apply> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        List<Apply> list = applyService.selectApplyListByCondition(queryWrapper);
        return list;
    }
    //根据用户姓名查找保养记录
    @RequestMapping("selectApplyByUserName")
    public List selectApplyByUserName(String name){
        String userId = null;
        /*
        * 此处需要写根据姓名获取userId的逻辑
        * */
        QueryWrapper<Apply> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        List<Apply> list = applyService.selectApplyListByCondition(queryWrapper);
        return list;
    }
    /**
     * 保养类型的接口
     * 增删改查
     */
    //新增类型
    @RequestMapping("saveApplyType")
    public Msg saveApplyType(String name){
        ApplyType applyType = new ApplyType(0,name);
        int i = applyTypeService.saveApplyType(applyType);
        if (i>0){
            return Msg.success().add("msg","增加成功");
        }else {
            return Msg.success().add("msg","增加失败");
        }
    }
    //删除类型
    @RequestMapping("deleteAppleType")
    public Msg deleteAppleType(String id){
        //根据id查询是否已存在此类型保养，是的话不可以被删除
        QueryWrapper<Apply> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("apply_type",id);
        List<Apply> list = applyService.selectApplyListByCondition(queryWrapper);
        if (!list.isEmpty()){
            return Msg.success().add("msg","此类型不可以被删除");
        }else {
            int i = applyTypeService.deleteAppleTypeById(id);
            if (i>0){
                return Msg.success().add("msg","删除成功");
            }else {
                return Msg.success().add("msg","删除失败");
            }
        }
    }
    //修改类型
    @RequestMapping("updateApplyType")
    public Msg updateApplyType(String id,String name){
        QueryWrapper<ApplyType> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        ApplyType applyType = applyTypeService.selectApplyTypeOneByCondition(queryWrapper);

        applyType.setName(name);
        int i = applyTypeService.updateAppleTypeById(applyType);
        if (i>0){
            return Msg.success().add("msg","跟新类型成功");
        }else {
            return Msg.success().add("msg","跟新类型失败");
        }
    }
    //查询类型list集合
    @RequestMapping("selectApplyType")
    public List selectApplyType(){
        List list = applyTypeService.selectApplyList(null);
        return list;
    }

}
