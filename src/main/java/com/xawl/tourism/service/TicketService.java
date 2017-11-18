package com.xawl.tourism.service;

import com.xawl.tourism.dao.TicketMapper;
import com.xawl.tourism.pojo.Ticket;
import com.xawl.tourism.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DT on 2017/10/12.
 */
@Service
public class TicketService {
    @Autowired
    TicketMapper ticketMapper;

    public Result findByUid(String uid) {
        return null;
    }

    public String check(String id, String readno, String sn) {
        return null;
    }

    public Result findByBid(String bid) {
        try {
            List<Ticket> list = ticketMapper.findByBid(bid);
            return Result.success(list);
        } catch (Exception e) {
            return Result.fail(405, "查询失败");
        }

    }
}
