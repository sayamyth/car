package cn.cnmua.car.controller;

import cn.cnmua.car.domian.Msg;
import cn.cnmua.car.domian.User;
import cn.cnmua.car.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author hjf
 * @Date 2020/2/23
 **/
@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    //登陆验证
    @RequestMapping("toLogin")
    public String toLogin(String username, String password, HttpServletRequest request){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",username);
        User u = userService.findUserByCondition(queryWrapper);
        if (!u.getUserName().isEmpty()){
            if (password.equals(u.getPassword())){
                if ("1".equals(u.getType())){
                    HttpSession session = request.getSession();
                    session.setAttribute("user",u);
                    return "index";
                } else{
                    HttpSession session = request.getSession();
                    session.setAttribute("user",u);
                    return "index-user";
                }
            }else {
                return "";
            }
        } else {
            return "";
        }
    }
}
