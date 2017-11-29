package com.xawl.tourism.controller;

import com.xawl.tourism.service.UserTicketService;
import com.xawl.tourism.utils.DefaultParam;
import com.xawl.tourism.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by DT on 2017/11/19.
 */
@Controller
@RequestMapping("/userTicket")
public class UserTicketContrller {
    @Autowired
    UserTicketService userTicketService;

    @GetMapping("/findbyOid.action")
    @ResponseBody
    public Result findbyOid(String oid, Integer page, Integer num) {
        if (page == null || page < 1) {
            page = 1;
        }
        if (num == null || num < 1) {
            num = DefaultParam.pageNum;
        }
        Result result = userTicketService.findbyOid (oid, page, num);
        return result;
    }

    /**
     * @param id(票的Id(一个UUID))
     * @param readno(校验码)
     * @param sn(设备号)
     * @param response
     * @return
     * @throws IOException
     */
    @GetMapping("/check.action")
    public String check(String id, String readno, String sn, HttpServletResponse response) throws IOException {
        System.out.println ("id=" + id + "--" + "readno=" + id + "--" + "sn=" + sn);
        response.setContentType ("text/html;charset=GB2312");
        String string = userTicketService.check (id, readno, sn);
        System.out.println ("id=" + id + "--" + "readno=" + id + "--" + "sn=" + sn);
        response.getWriter ().print (string);
        return null;
    }
}
