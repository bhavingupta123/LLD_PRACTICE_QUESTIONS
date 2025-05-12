package com.org.bookmyshow.service.seatbooking;

import com.org.bookmyshow.model.Seat;

import java.util.List;

public class ExactMatchSeatBooking implements SeatBookingStrategy {

    @Override
    public Seat findAvailableSeat(List<Seat> seats, String seatId) {
        for (Seat seat : seats) {
            if (seat.getSeatId().equals(seatId) && !seat.getBooked()) {
                return seat;
            }
        }
        return null;
    }
}