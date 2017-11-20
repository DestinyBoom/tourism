package com.xawl.tourism.dao;

import com.xawl.tourism.pojo.UserTicket;

import java.util.List;

public interface UserTicketMapper {
    int deleteByPrimaryKey(String code);

    int insert(UserTicket record);

    int insertSelective(UserTicket record);

    UserTicket selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(UserTicket record);

    int updateByPrimaryKey(UserTicket record);

    List<UserTicket> findByUid(String uid);
}