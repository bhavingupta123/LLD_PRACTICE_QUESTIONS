package com.org.bookmyshow.service;

public interface ITicketBookingService {

    Boolean bookATicket(String theaterId, String screenId, String seatId, String userId);
}
