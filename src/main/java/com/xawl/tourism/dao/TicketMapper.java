package com.xawl.tourism.dao;

import com.xawl.tourism.pojo.Ticket;

public interface TicketMapper {
    int deleteByPrimaryKey(String tid);

    int insert(Ticket record);

    int insertSelective(Ticket record);

    Ticket selectByPrimaryKey(String tid);

    int updateByPrimaryKeySelective(Ticket record);

    int updateByPrimaryKey(Ticket record);
}