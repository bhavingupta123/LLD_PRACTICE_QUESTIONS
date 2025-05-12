package com.org.bookmyshow.controllers;

import com.org.bookmyshow.service.TicketBookingService;

public class TicketBookingController {

    TicketBookingService ticketBookingService;

    public TicketBookingController(TicketBookingService ticketBookingService){
        this.ticketBookingService = ticketBookingService;
    }

    public Boolean bookATicket(String theaterId, String screenId, String seatId, String userId){
        boolean isbooked =  ticketBookingService.bookATicket(theaterId, screenId, seatId, userId);
        return isbooked;
    }
}
