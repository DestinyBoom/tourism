package com.xawl.tourism.service;

import com.xawl.tourism.dao.BusinessImgMapper;
import com.xawl.tourism.pojo.BusinessImg;
import com.xawl.tourism.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DT on 2017/11/23.
 */
@Service
public class BusinessImgService {
    @Autowired
    BusinessImgMapper businessImgMapper;

    public Result findAll(String bid) {
        try {
            List<BusinessImg> list = businessImgMapper.findByBid(bid);
            return Result.success(list);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("查询失败");
        }
    }
}
