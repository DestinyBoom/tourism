package com.xawl.tourism.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xawl.tourism.dao.BusinessMapper;
import com.xawl.tourism.dao.TicketMapper;
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
    @Autowired
    private TicketMapper ticketMapper;

    public Result findAll(Integer page, Integer num) {
        try {
            PageHelper.startPage(page, num);
            List<Business> list = businessMapper.findAll();
            PageInfo<Business> pageInfo = new PageInfo<Business>(list);
            for (Business bs : pageInfo.getList()) {
                Float minPrice = ticketMapper.findByMinPriceAndBid(bs.getBid());
                if (minPrice == null || minPrice == 0) {
                    bs.setMinPrice(0);
                } else {
                    bs.setMinPrice(ticketMapper.findByMinPriceAndBid(bs.getBid()));
                }
            }
            return Result.success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(405, "查询失败");
        }

    }

    public Result findById(String bid) {
        try {
            Business business = businessMapper.findById(bid);
            return Result.success(business);
        } catch (Exception e) {
            return Result.fail(405, "查询失败");
        }
    }
}
