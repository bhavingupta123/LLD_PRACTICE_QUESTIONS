package com.org.bookmyshow.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String userId;
    private String emailId;
    List<Ticket> ticketList = new ArrayList<>();

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public User(String userId, String emailId) {
        this.userId = userId;
        this.emailId = emailId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void addTicket(Ticket ticket){
        ticketList.add(ticket);
    }
}
