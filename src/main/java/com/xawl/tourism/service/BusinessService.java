package com.xawl.tourism.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xawl.tourism.dao.*;
import com.xawl.tourism.pojo.*;
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
    @Autowired
    private BusinessKeepsakeMapper businessKeepsakeMapper;
    @Autowired
    private BusinessInfoMapper businessInfoMapper;
    @Autowired
    private BusinessImgMapper businessImgMapper;

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
            BusinessVo businessVo = new BusinessVo();
            Business business = businessMapper.findById(bid);
            businessVo.setBusiness(business);
            List<Ticket> tickets = ticketMapper.findByBid(bid);
            businessVo.setTicket(tickets);
            List<BusinessKeepsake> businessKeepsakes = businessKeepsakeMapper.findByBid(bid);
            businessVo.setBusinessKeepsake(businessKeepsakes);
            BusinessInfo businessInfo = businessInfoMapper.selectByPrimaryKey(bid);
            businessVo.setBusinessInfo(businessInfo);
            List<BusinessImg> businessImgs = businessImgMapper.findByBid(bid);
            businessVo.setBusinessImgs(businessImgs);
            return Result.success(businessVo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(405, "查询失败");
        }
    }
}
