package com.xawl.tourism.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xawl.tourism.dao.BusinessDeviceMapper;
import com.xawl.tourism.dao.OrderMapper;
import com.xawl.tourism.dao.TicketMapper;
import com.xawl.tourism.dao.UserTicketMapper;
import com.xawl.tourism.pojo.Order;
import com.xawl.tourism.pojo.Ticket;
import com.xawl.tourism.pojo.TicketVo;
import com.xawl.tourism.pojo.UserTicket;
import com.xawl.tourism.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DT on 2017/11/19.
 */
@Service
public class UserTicketService {
    @Autowired
    UserTicketMapper userTicketMapper;
    @Autowired
    BusinessDeviceMapper businessDeviceMapper;
    @Autowired
    TicketMapper ticketMapper;
    @Autowired
    OrderMapper orderMapper;

    public Result findbyOid(String oid, Integer page, Integer num) {
        try {
            PageHelper.startPage (page, num);
            List<TicketVo> list = userTicketMapper.findbyOid (oid);
            PageInfo<TicketVo> pageInfo = new PageInfo<TicketVo> (list);
            return Result.success (pageInfo);
        } catch (Exception e) {
            e.printStackTrace ();
            return Result.fail (405, "查询失败");
        }
    }


    public String check(String id, String readno, String sn) {
        UserTicket userTicket = userTicketMapper.selectByPrimaryKey (id);
        Ticket ticket = ticketMapper.selectByPrimaryKey (userTicket.getTid ());
        List<String> list = businessDeviceMapper.findDidListByBid (ticket.getBid ());
        Order order = orderMapper.selectByPrimaryKey (userTicket.getOid ());
        if (order.getStatus () == 0) {
            return "result=0;readno=" + readno + ";cnt=001;str1=111str1end;str2=1221123str2end;str3=34str3end;sndstr=订单未支付sndstrend;";
        } else if (list == null || list.size () <= 0) {
            return "result=0;readno=" + readno + ";cnt=001;str1=111str1end;str2=1221123str2end;str3=34str3end;sndstr=错误sndstrend;";
        } else if (!list.contains (sn)) {
            return "result=0;readno=" + readno + ";cnt=001;str1=111str1end;str2=1221123str2end;str3=34str3end;sndstr=门票错误sndstrend;";
        } else if (userTicket.getIsUse () == true) {
            return "result=0;readno=" + readno + ";cnt=001;str1=111str1end;str2=1221123str2end;str3=34str3end;sndstr=门票已使用sndstrend;";
        } else {
            //将票的isuse字段修改为true(1)
            Map map = new HashMap ();
            map.put ("code", userTicket.getCode ());
            map.put ("useTime", new Date ());
            userTicketMapper.tickTicket (map);
            //cnt开门信号(开门次数)
            String cnt = "";
            int num = userTicket.getNum ();
            if (num < 100 && num > 10) cnt = "0" + num;
            if (num < 10) cnt = "00" + num;
            return "result=1;readno=" + readno + ";cnt=" + cnt + ";str1=111：str1end;str2=1221123str2end;str3=34str3end;sndstr=欢迎光临sndstrend;";
        }
    }
}

