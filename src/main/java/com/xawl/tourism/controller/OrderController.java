package com.xawl.tourism.controller;

import com.xawl.tourism.pojo.Order;
import com.xawl.tourism.service.OrderService;
import com.xawl.tourism.utils.DefaultParam;
import com.xawl.tourism.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by DT on 2017/11/17.
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/findOrder.action")
    @ResponseBody
    public Result findOrder(Order order, Integer page, Integer num) {
        if (page == null || page == 0) {
            page = 1;
        }
        if (num == null || num == 0) {
            num = DefaultParam.pageNum;
        }
        Result result = orderService.findOrder(order, page, num);
        return result;
    }
}
