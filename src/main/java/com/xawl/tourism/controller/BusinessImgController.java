package com.xawl.tourism.controller;

import com.xawl.tourism.service.BusinessImgService;
import com.xawl.tourism.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by DT on 2017/11/23.
 */
@Controller
@RequestMapping("/businessImg")
public class BusinessImgController {
    @Autowired
    BusinessImgService businessImgService;

    @GetMapping("/findAll.action")
    @ResponseBody
    public Result findAll(String bid) {
        if (bid == null || bid == "") {
            return Result.fail("请传入商家ID");
        }
        Result result = businessImgService.findAll(bid);
        return result;
    }

}
