package com.xawl.tourism.controller;

import com.xawl.tourism.service.TicketService;
import com.xawl.tourism.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by DT on 2017/10/12.
 */
@Controller
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    TicketService ticketService;

    @GetMapping("/findByBid.action")
    @ResponseBody
    public Result findByBid(String bid) {
        Result result = ticketService.findByBid(bid);
        return result;
    }

    /**
     * 使用票
     */
    @GetMapping("/check.action")
    public String check(String id, String readno, String sn, HttpServletResponse response) throws IOException {
        System.out.println("id=" + id + "--" + "readno=" + id + "--" + "sn=" + sn);
        response.setContentType("text/html;charset=GB2312");
        String string = ticketService.check(id, readno, sn);
        System.out.println("id=" + id + "--" + "readno=" + id + "--" + "sn=" + sn);
        response.getWriter().print(string);
        return null;
    }

}
