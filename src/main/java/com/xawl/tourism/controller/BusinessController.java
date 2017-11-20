package com.xawl.tourism.controller;

import com.xawl.tourism.service.BusinessService;
import com.xawl.tourism.utils.DefaultParam;
import com.xawl.tourism.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by DT on 2017/11/15.
 */
@Controller
@RequestMapping("/business")
public class BusinessController {
    @Autowired
    private BusinessService businessService;

    /**
     * 查询所有商家()
     *
     * @param page(页码,默认第一页)
     * @param num(每页记录数,默认每页8个)
     * @return
     */
    @GetMapping("/findAll.action")
    @ResponseBody
    public Result findAll(Integer page, Integer num) {
        if (page == null || page < 1) {
            page = 1;
        }
        if (num == null || num < 1) {
            num = DefaultParam.pageNum;
        }
        Result result = businessService.findAll(page, num);
        return result;
    }

    /**
     * 根据ID查询商家
     *
     * @param bid(商家Id)
     * @return
     */
    @GetMapping("/findById.action")
    @ResponseBody
    public Result findById(String bid) {
        if (bid == null) {
            return Result.fail(300, "请传入商家Id");
        }
        Result result = businessService.findById(bid);
        return result;
    }

}
