package com.org.bookmyshow.model;

public class Seat {

    String seatId, name;
    Boolean isBooked;

    public Seat(String seatId, Boolean isBooked) {
        this.seatId = seatId;
        this.isBooked = isBooked;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getBooked() {
        return isBooked;
    }

    public void setBooked(Boolean booked) {
        isBooked = booked;
    }
}
