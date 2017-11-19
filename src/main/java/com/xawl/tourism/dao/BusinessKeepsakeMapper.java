package com.xawl.tourism.dao;

import com.xawl.tourism.pojo.BusinessKeepsake;

import java.util.List;

public interface BusinessKeepsakeMapper {
    int deleteByPrimaryKey(String kid);

    int insert(BusinessKeepsake record);

    int insertSelective(BusinessKeepsake record);

    BusinessKeepsake selectByPrimaryKey(String kid);

    int updateByPrimaryKeySelective(BusinessKeepsake record);

    int updateByPrimaryKeyWithBLOBs(BusinessKeepsake record);

    int updateByPrimaryKey(BusinessKeepsake record);

    List<BusinessKeepsake> findByBid(String bid);
}