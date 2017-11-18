package com.xawl.tourism.controller;


import com.xawl.tourism.pojo.User;
import com.xawl.tourism.service.UserService;
import com.xawl.tourism.utils.Result;
import com.xawl.tourism.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
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

    @ResponseBody
    @RequestMapping("/addUser.action")
    public Result addUser(User user) {
        user.setAccount("qq729742011");
        user.setPass("123456");
        user.setPhone("15229265560");
        user.setUid(UUIDUtils.createUUID());
        user.setSigninTime(new Date());
        user.setSex("M");
        Result result = userService.addUser(user);
        return result;
    }
}
