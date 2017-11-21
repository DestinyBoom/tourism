package com.xawl.tourism.pojo;

/**
 * Created by DT on 2017/11/21.
 */
public class TicketVo {
    private Ticket ticket;
    private UserTicket userTicket;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public UserTicket getUserTicket() {
        return userTicket;
    }

    public void setUserTicket(UserTicket userTicket) {
        this.userTicket = userTicket;
    }
}
