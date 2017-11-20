package com.xawl.tourism.dao;

import com.xawl.tourism.pojo.BusinessImg;

import java.util.List;

public interface BusinessImgMapper {
    int deleteByPrimaryKey(String imgid);

    int insert(BusinessImg record);

    int insertSelective(BusinessImg record);

    BusinessImg selectByPrimaryKey(String imgid);

    int updateByPrimaryKeySelective(BusinessImg record);

    int updateByPrimaryKey(BusinessImg record);

    List<BusinessImg> findByBid(String bid);
}