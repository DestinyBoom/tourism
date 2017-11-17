package com.xawl.tourism.service;

import com.xawl.tourism.dao.UserMapper;
import com.xawl.tourism.pojo.User;
import com.xawl.tourism.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * Created by zb on 2017/11/14.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public Result regist(User user) throws Exception {
        //String phoneRex ="^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\\\d{8}$";
        //Pattern phonePat = Pattern.compile(phoneRex);
        User userRes = this.userMapper.selectByPhone(user.getPhone());
        if (userRes != null){
            return Result.fail(201, "手机号已经注册！");
        }
        /*if (!phonePat.matcher(user.getPhone()).find()){
            return Result.fail(202, "手机号格式错误！");
        }*/
        if (user.getPass().length() < 6 || user.getPass().length() > 16){
            return Result.fail(203, "密码应该在6-16位之间，包括6和16");
        }
        if (!user.getSex().equals("M") && !user.getSex().equals("W")){
            return Result.fail(204, "传值错误，男性应该是M，女性应该是W");
        }
        user.setUid(UUID.randomUUID().toString().replaceAll("-", ""));
        user.setAccount("用户_"+ (int)Math.random()*1000000);

        //确定计算方法
        MessageDigest md5= MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newPass=base64en.encode(md5.digest(user.getPass().getBytes("utf-8")));
        user.setPass(newPass);

        user.setSigninTime(new Date());
        int num = this.userMapper.insertSelective(user);
        if (num == 1){
            User  UserRes = this.userMapper.selectByPhone(user.getPhone());
            return Result.success(UserRes);
        }
        return Result.fail(205,"注册失败!");
    }

    /*public static void main(String args[]){
        UserService us = new UserService();
        User user = new User();
        user.setPhone("13572232331");
        user.setPass("123456");
        try {
            us.regist(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
