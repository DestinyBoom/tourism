package com.xawl.tourism.pojo;

import java.util.List;

/**
 * Created by DT on 2017/11/19.
 */
public class BusinessVo {
    private Business business;
    private List<BusinessKeepsake> businessKeepsake;
    private List<Ticket> ticket;
    private BusinessInfo businessInfo;
    private List<BusinessImg> businessImgs;

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public List<BusinessKeepsake> getBusinessKeepsake() {
        return businessKeepsake;
    }

    public void setBusinessKeepsake(List<BusinessKeepsake> businessKeepsake) {
        this.businessKeepsake = businessKeepsake;
    }

    public List<Ticket> getTicket() {
        return ticket;
    }

    public void setTicket(List<Ticket> ticket) {
        this.ticket = ticket;
    }

    public BusinessInfo getBusinessInfo() {
        return businessInfo;
    }

    public void setBusinessInfo(BusinessInfo businessInfo) {
        this.businessInfo = businessInfo;
    }

    public List<BusinessImg> getBusinessImgs() {
        return businessImgs;
    }

    public void setBusinessImgs(List<BusinessImg> businessImgs) {
        this.businessImgs = businessImgs;
    }
}
