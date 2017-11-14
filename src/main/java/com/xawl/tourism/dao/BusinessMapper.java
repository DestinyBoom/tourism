package com.xawl.tourism.dao;

import com.xawl.tourism.pojo.Business;

public interface BusinessMapper {
    int deleteByPrimaryKey(String bid);

    int insert(Business record);

    int insertSelective(Business record);

    Business selectByPrimaryKey(String bid);

    int updateByPrimaryKeySelective(Business record);

    int updateByPrimaryKey(Business record);
}