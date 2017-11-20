package com.xawl.tourism.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xawl.tourism.dao.UserTicketMapper;
import com.xawl.tourism.pojo.UserTicket;
import com.xawl.tourism.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DT on 2017/11/19.
 */
@Service
public class UserTicketService {
    @Autowired
    UserTicketMapper userTicketMapper;

    public Result findByUid(String oid, Integer page, Integer num) {
        try {
            PageHelper.startPage(page, num);
            List<UserTicket> list = userTicketMapper.findByUid(oid);
            PageInfo<UserTicket> pageInfo = new PageInfo<UserTicket>(list);
            return Result.success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(405, "查询失败");
        }
    }
}

