package top.mypath.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.mypath.commons.CodeMsg;
import top.mypath.commons.Result;
import top.mypath.domain.User;
import top.mypath.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 李亚林
 * @date 2019/12/22 18:29
 */
@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/login")

    public @ResponseBody Result login(HttpSession session, String username, String password ){
        User user = userService.findById(username);
        if(username!=null&&password!=null) {
            if (password.equals(user.getPassword())) {
                session.setAttribute("loginUser", user);
                return Result.success(user);
            } else {
                return Result.error(CodeMsg.LOGIN_INFO_ERROR);
            }
        }else {
            return Result.error(CodeMsg.LOGIN_INFO_NULL);
        }

    }

    @RequestMapping(path = "/register")
    public @ResponseBody Result register(HttpSession session,User user){
        boolean registerFlag=false;
        if(user!=null){
            if(userService.findById(user.getUserId())==null) {
                registerFlag = userService.insert(user);
                if(registerFlag){
                    session.setAttribute("loginUser",user);
                    return Result.success(user);
                }else {
                    return Result.error(CodeMsg.REGISTER_FAIL);
                }
            }else {
                return Result.error(CodeMsg.REGISTER_FAIL_REPEAT);
            }
        }else {
            return Result.error(CodeMsg.REGISTER_INFO_NULL);
        }
    }

    @RequestMapping(path = "/getMyInfo")
    public Result getMyInfo(HttpSession session){
        User user=(User)session.getAttribute("loginUser");
        return Result.success(user);
    }




}
