package cn.cnmua.car.service;

import cn.cnmua.car.domian.Message;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *
 * message表操作接口
 */
public interface MessageService {

    int saveMessage(Message message);

    int deleteMessageById(String id);

    int updateMessageById(Message message);

    Message selectMessageById(String id);

    Page selectMessageByCondition(Page page,QueryWrapper queryWrapper);
}
