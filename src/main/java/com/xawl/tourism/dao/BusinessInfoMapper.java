package com.xawl.tourism.dao;

import com.xawl.tourism.pojo.BusinessInfo;

public interface BusinessInfoMapper {
    int deleteByPrimaryKey(String bid);

    int insert(BusinessInfo record);

    int insertSelective(BusinessInfo record);

    BusinessInfo selectByPrimaryKey(String bid);

    int updateByPrimaryKeySelective(BusinessInfo record);

    int updateByPrimaryKeyWithBLOBs(BusinessInfo record);
}