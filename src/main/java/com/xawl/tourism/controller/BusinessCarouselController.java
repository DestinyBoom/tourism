package com.xawl.tourism.controller;

import com.xawl.tourism.service.BusinessCarouselContService;
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
@RequestMapping("/businessCarousel")
public class BusinessCarouselController {
    @Autowired
    BusinessCarouselContService businessCarouselContService;

    @GetMapping("/findAll.action")
    @ResponseBody
    public Result findAll() {
        Result result = businessCarouselContService.findAll();
        return result;
    }
}
