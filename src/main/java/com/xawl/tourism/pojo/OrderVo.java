package com.xawl.tourism.pojo;

import java.util.List;

/**
 * Created by DT on 2017/11/22.
 */
public class OrderVo {
    private Order order;
    private List<UserTicket> userTicketLists;

    public OrderVo() {
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<UserTicket> getUserTicketLists() {
        return userTicketLists;
    }

    public void setUserTicketLists(List<UserTicket> userTicketLists) {
        this.userTicketLists = userTicketLists;
    }
}
