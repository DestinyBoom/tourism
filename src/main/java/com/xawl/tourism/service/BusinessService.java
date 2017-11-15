package com.xawl.tourism.service;

import com.xawl.tourism.dao.BusinessMapper;
import com.xawl.tourism.pojo.Business;
import com.xawl.tourism.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DT on 2017/11/15.
 */
@Service
public class BusinessService {
    @Autowired
    private BusinessMapper businessMapper;

    public Result findAll() {
        try {
            List<Business> list = businessMapper.findAll();
            return Result.success(list);
        } catch (Exception e) {
            return Result.fail(405, "查询失败");
        }

    }
}
