package com.xawl.tourism.service;

import com.xawl.tourism.dao.UserMapper;
import com.xawl.tourism.pojo.User;
import com.xawl.tourism.utils.MD5Utils;
import com.xawl.tourism.utils.RandomUtils;
import com.xawl.tourism.utils.Result;
import com.xawl.tourism.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
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

    /**
     * 登录业务逻辑
     * @param user
     * @return
     * @throws Exception
     */
    public Result login(User user) throws Exception {
        User userRes = this.userMapper.selectByPhone(user.getPhone());
        if (userRes == null) {
            return Result.fail(201, "该用户不存在！");
        }
        if (user.getPhone() == null || user.getPass() == null || user.getPhone().isEmpty() || user.getPass().isEmpty()){
            return Result.fail(202, "用户名或密码不能为空！");
        }
        if(user.getPhone().equals(userRes.getPhone()) && MD5Utils.addMD5(user.getPass()).equals(userRes.getPass())){
            return Result.success(userRes);
        }
        return Result.fail(203, "用户名或密码错误！");
    }

    /**
     * 注册业务逻辑
     * @param user
     * @return
     * @throws Exception
     */
    @Transactional
    public Result regist(User user) throws Exception {
        Pattern phoneRex = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        User userRes = this.userMapper.selectByPhone(user.getPhone());

        //校验前端信息
        if (userRes != null) {
            return Result.fail(201, "手机号已经注册！");
        }
        if (!phoneRex.matcher(user.getPhone()).matches()){
            return Result.fail(202, "手机号格式错误！");
        }
        if (user.getPass().length() < 6 || user.getPass().length() > 16) {
            return Result.fail(203, "密码应该在6-16位之间，包括6和16。");
        }
        if (user.getSex() != null) {
            if (!user.getSex().equals("M") && !user.getSex().equals("W")) {
                return Result.fail(204, "传值错误，男性应该是M，女性应该是W。");
            }
        }

        //设置存入数据库的数据
        user.setUid(UUIDUtils.createUUID());
        user.setAccount("用户_" + RandomUtils.getRandom());
        user.setPass(MD5Utils.addMD5(user.getPass()));
        user.setSigninTime(new Date());

        int row = this.userMapper.insertSelective(user);
        //判断是否成功插入数据库
        if (row == 1) {
            User userResult = this.userMapper.selectByPhone(user.getPhone());
            return Result.success(userResult);
        }
        return Result.fail(205, "注册失败！");
    }
}
