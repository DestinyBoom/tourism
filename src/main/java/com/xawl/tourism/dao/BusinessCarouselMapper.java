package com.xawl.tourism.dao;

import com.xawl.tourism.pojo.BusinessCarousel;

public interface BusinessCarouselMapper {
    int deleteByPrimaryKey(String bcid);

    int insert(BusinessCarousel record);

    int insertSelective(BusinessCarousel record);

    BusinessCarousel selectByPrimaryKey(String bcid);

    int updateByPrimaryKeySelective(BusinessCarousel record);

    int updateByPrimaryKey(BusinessCarousel record);
}