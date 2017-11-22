package com.xawl.tourism.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xawl.tourism.dao.OrderMapper;
import com.xawl.tourism.pojo.Order;
import com.xawl.tourism.pojo.UserTicketList;
import com.xawl.tourism.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DT on 2017/11/17.
 */
@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    public Result findOrder(Order order, Integer page, Integer num) {
        try {
            PageHelper.startPage(page, num);
            List<Order> list = orderMapper.select(order);
            PageInfo<Order> pageInfo = new PageInfo<Order>(list);
            return Result.success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("查询失败");
        }

    }

    public Result createOrder(String bid, UserTicketList userTickets) {
        try {



            return Result.success(null);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("查询失败");
        }
    }
}
