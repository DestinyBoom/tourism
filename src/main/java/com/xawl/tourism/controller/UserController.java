package com.xawl.tourism.controller;


import com.xawl.tourism.interceptor.Role;
import com.xawl.tourism.pojo.User;
import com.xawl.tourism.service.UserService;
import com.xawl.tourism.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * Created by zb on 2017/11/14.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/findAll.action")
    public List<User> findAll(HttpServletRequest request, HttpServletResponse response) {
        return userService.findAll();
    }

    /**
     * 登录接口
     * @param user
     * @return
     */
    @ResponseBody
    @GetMapping ("/login.action")
    public Result login(HttpServletRequest request, User user) {
        try {
            return this.userService.login(request, user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.fail(500, "系统错误");
    }

    /**
     * 注册接口
     * @param user
     * @return
     */
    @ResponseBody
    @PostMapping("/regist.action")
    public Result regist(User user) {
        try {
            return this.userService.regist(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.fail(500, "系统错误");
    }

    /**
     * 按手机号查询用户信息
     * @param phone
     * @return
     */
    @Role(role=Role.ROLE_USER)
    @ResponseBody
    @GetMapping("/selectByPhone.action")
    public Result selectByPhone(String phone) {
        try {
            return this.userService.selectByPhone(phone);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.fail(500, "系统错误");
    }

    /**
     * 根据主键修改用户信息
     * @param user
     * @return
     */
    @Role(role=Role.ROLE_USER)
    @ResponseBody
    @PostMapping("/updateByPrimaryKey.action")
    public Result updateByPrimaryKey(User user) {
        try {
            return this.userService.updateByPrimaryKey(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.fail(500, "系统错误");
    }
}
