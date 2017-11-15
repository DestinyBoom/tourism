package com.xawl.tourism.controller;

import com.xawl.tourism.service.BusinessService;
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

    @GetMapping("/findAll.action")
    @ResponseBody
    public Result findAll() {
        Result result = businessService.findAll();
        return result;
    }

}
