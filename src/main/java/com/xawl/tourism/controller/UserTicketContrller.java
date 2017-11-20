package com.xawl.tourism.controller;

import com.xawl.tourism.service.UserTicketService;
import com.xawl.tourism.utils.DefaultParam;
import com.xawl.tourism.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by DT on 2017/11/19.
 */
@Controller
@RequestMapping("/userTicket")
public class UserTicketContrller {
    @Autowired
    UserTicketService userTicketService;

    @GetMapping("/findbyOid.action")
    @ResponseBody
    public Result findByUid(String oid, Integer page, Integer num) {
        if (page == null || page < 1) {
            page = 1;
        }
        if (num == null || num < 1) {
            num = DefaultParam.pageNum;
        }
        Result result = userTicketService.findByUid(oid, page, num);
        return result;
    }
}
