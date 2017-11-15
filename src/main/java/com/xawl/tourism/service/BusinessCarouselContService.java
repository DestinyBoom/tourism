package com.xawl.tourism.service;

import com.xawl.tourism.dao.BusinessCarouselMapper;
import com.xawl.tourism.pojo.BusinessCarousel;
import com.xawl.tourism.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DT on 2017/11/15.
 */
@Service
public class BusinessCarouselContService {
    @Autowired
    BusinessCarouselMapper businessCarouselMapper;

    public Result findAll() {
        try {
            List<BusinessCarousel> list = businessCarouselMapper.findAll();
            return Result.success(list);
        } catch (Exception e) {
            return Result.fail("查询失败");
        }
    }
}
