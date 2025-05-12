package com.org.bookmyshow.model;

public class Ticket {

    private String ticketId;
    private String userId;
    private String screenId;
    private String seatId;

    public Ticket(String ticketId, String userId, String screenId, String seatId) {
        this.ticketId = ticketId;
        this.userId = userId;
        this.screenId = screenId;
        this.seatId = seatId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getScreenId() {
        return screenId;
    }

    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }
}
