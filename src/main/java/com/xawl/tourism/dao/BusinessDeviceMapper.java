package com.xawl.tourism.dao;

import com.xawl.tourism.pojo.BusinessDevice;

import java.util.List;

public interface BusinessDeviceMapper {
    int deleteByPrimaryKey(String did);

    int insert(BusinessDevice record);

    int insertSelective(BusinessDevice record);

    BusinessDevice selectByPrimaryKey(String did);

    int updateByPrimaryKeySelective(BusinessDevice record);

    int updateByPrimaryKey(BusinessDevice record);

    List<String> findDidListByBid(String bid);
}