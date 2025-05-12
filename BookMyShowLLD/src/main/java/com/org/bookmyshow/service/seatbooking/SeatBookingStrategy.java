package com.org.bookmyshow.service.seatbooking;

import com.org.bookmyshow.model.Seat;

import java.util.List;

public interface SeatBookingStrategy {
    Seat findAvailableSeat(List<Seat> seats, String seatId);
}
