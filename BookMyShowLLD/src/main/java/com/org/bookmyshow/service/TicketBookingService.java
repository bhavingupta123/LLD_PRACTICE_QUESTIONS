package com.org.bookmyshow.service;

import com.org.bookmyshow.model.Screen;
import com.org.bookmyshow.model.Seat;
import com.org.bookmyshow.model.Ticket;
import com.org.bookmyshow.model.User;
import com.org.bookmyshow.repository.TheaterRepo;
import com.org.bookmyshow.repository.TicketRepo;
import com.org.bookmyshow.repository.UserRepository;
import com.org.bookmyshow.service.seatbooking.SeatBookingStrategy;

import java.util.List;
import java.util.UUID;

public class TicketBookingService implements ITicketBookingService{

    private final TheaterRepo theaterRepo;
    private final TicketRepo ticketRepo;
    private final UserRepository userRepository;
    private final SeatBookingStrategy bookingStrategy;

    public TicketBookingService(TheaterRepo theaterRepo, TicketRepo ticketRepo,
                                UserRepository userRepository, SeatBookingStrategy bookingStrategy) {
        this.theaterRepo = theaterRepo;
        this.ticketRepo = ticketRepo;
        this.userRepository = userRepository;
        this.bookingStrategy = bookingStrategy;
    }

    public synchronized Boolean bookATicket(String theaterId, String screenId, String seatId, String userId) {
        List<Screen> screens = theaterRepo.getScreensByTheaterId(theaterId);
        if (screens == null) return false;

        for (Screen screen : screens) {
            if (screen.getId().equals(screenId)) {
                Seat seat = bookingStrategy.findAvailableSeat(screen.getSeats(), seatId);
                if (seat == null) return false;

                seat.setBooked(true);
                Ticket ticket = new Ticket(UUID.randomUUID().toString(), userId, screenId, seat.getSeatId());
                ticketRepo.getTicketList().add(ticket);

                User user = userRepository.getUserById(userId);
                if (user != null) {
                    user.addTicket(ticket);
                    return true;
                }
            }
        }
        return false;
    }
}
