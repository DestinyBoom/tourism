package com.xawl.tourism.dao;

import com.xawl.tourism.pojo.BusinessImg;

public interface BusinessImgMapper {
    int deleteByPrimaryKey(String imgid);

    int insert(BusinessImg record);

    int insertSelective(BusinessImg record);

    BusinessImg selectByPrimaryKey(String imgid);

    int updateByPrimaryKeySelective(BusinessImg record);

    int updateByPrimaryKey(BusinessImg record);
}