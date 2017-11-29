package com.xawl.tourism.dao;

import com.xawl.tourism.pojo.TicketVo;
import com.xawl.tourism.pojo.UserTicket;

import java.util.List;
import java.util.Map;

public interface UserTicketMapper {
    int deleteByPrimaryKey(String code);

    int insert(UserTicket record);

    int insertSelective(UserTicket record);

    UserTicket selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(UserTicket record);

    int updateByPrimaryKey(UserTicket record);

    List<TicketVo> findbyOid(String oid);

    void tickTicket(Map code);
}