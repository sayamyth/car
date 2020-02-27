package cn.cnmua.car.service.Imp;

import cn.cnmua.car.dao.MessageMapper;
import cn.cnmua.car.domian.Message;
import cn.cnmua.car.service.MessageService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageImp implements MessageService {
    @Autowired
    private MessageMapper mapper;

    @Override
    public int saveMessage(Message message) {
        return mapper.insert(message);
    }

    @Override
    public int deleteMessageById(String id) {
        return mapper.deleteById(id);
    }

    @Override
    public int updateMessageById(Message message) {
        return mapper.updateById(message);
    }

    @Override
    public Message selectMessageById(String id) {
        return mapper.selectById(id);
    }

    @Override
    public Page selectMessageByCondition(Page page, QueryWrapper queryWrapper) {
        return (Page) mapper.selectPage(page,queryWrapper);
    }
}
