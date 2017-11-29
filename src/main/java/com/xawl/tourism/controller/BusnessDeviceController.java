package com.xawl.tourism.controller;

import com.xawl.tourism.service.BusnessDeviceSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by DT on 2017/11/29.
 * @version 1.0
 **/
@RestController("/busnessDevice")
public class BusnessDeviceController {
    @Autowired
    BusnessDeviceSerive busnessDeviceSerive;
}
