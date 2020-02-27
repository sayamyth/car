package cn.cnmua.car.controller;

import cn.cnmua.car.domian.Message;
import cn.cnmua.car.domian.Msg;
import cn.cnmua.car.service.MessageService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author hjf
 * @Date 2020/1/8
 **/
@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;

    //用户新增留言
    @RequestMapping("saveMessageByCustomer")
    public Msg saveMessageByCustomer(String shopId, String orderNum, String userMessage){
        String userId = null;
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD : HH:mm:ss");
        String sdfDate = sdf.format(date);
        Message message = new Message(0,userId,shopId,orderNum,userMessage,sdfDate,null,null);
        int i = messageService.saveMessage(message);
        if (i>0){
            return Msg.success().add("msg","留言成功");
        }else {
            return Msg.success().add("msg","留言失败");
        }
    }
    //管理员回复留言
    @RequestMapping("saveMessageByAdmin")
    public Msg saveMessageByAdmin(String id,String adminMessage){
        //获取时间
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD : HH:mm:ss");
        String sdfDate = sdf.format(date);
        //通过id获取此条留言
        Message message = messageService.selectMessageById(id);
        message.setAdminTime(sdfDate);
        message.setAdminMessage(adminMessage);
        int i = messageService.updateMessageById(message);
        if (i>0){
            return Msg.success().add("msg","回复留言成功");
        }else {
            return Msg.success().add("msg","回复留言失败");
        }
    }
    //用户修改留言
    @RequestMapping("updateMessageByCustomer")
    public Msg updateMessageByCustomer(String id,String userMessage){
        //通过id获取此条留言
        Message message = messageService.selectMessageById(id);
        message.setUserMessage(userMessage);
        int i = messageService.updateMessageById(message);
        if (i>0){
            return Msg.success().add("msg","留言修改成功");
        }else {
            return Msg.success().add("msg","留言修改失败");
        }
    }
    //查看留言
    @RequestMapping("selectMessageByCondition")
    public Page selectMessageByCondition(@RequestParam(value = "page", defaultValue = "1") Integer page,@RequestParam(value = "limit", defaultValue = "10") Integer limit){
        Page<Message> page1 = new Page<>(page,limit);
        Page message = messageService.selectMessageByCondition(page1, null);
        return message;
    }


}
