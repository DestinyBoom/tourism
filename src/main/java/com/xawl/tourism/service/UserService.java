package com.xawl.tourism.service;

import com.xawl.tourism.dao.UserMapper;
import com.xawl.tourism.pojo.User;
import com.xawl.tourism.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Result addUser(User user) {
        try {
            userMapper.insert(user);
            return Result.success(user);
        } catch (Exception e) {
            return Result.fail(405, "添加失败");
        }
    }
}
