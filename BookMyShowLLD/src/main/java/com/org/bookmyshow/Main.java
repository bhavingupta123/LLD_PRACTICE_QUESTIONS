package com.org.bookmyshow;

import com.org.bookmyshow.controllers.TheatherController;
import com.org.bookmyshow.controllers.TicketBookingController;
import com.org.bookmyshow.model.Seat;
import com.org.bookmyshow.model.User;
import com.org.bookmyshow.repository.TheaterRepo;
import com.org.bookmyshow.repository.TicketRepo;
import com.org.bookmyshow.repository.UserRepository;
import com.org.bookmyshow.service.TheaterService;
import com.org.bookmyshow.service.TicketBookingService;
import com.org.bookmyshow.service.seatbooking.ExactMatchSeatBooking;
import com.org.bookmyshow.service.seatbooking.SeatBookingStrategy;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        UserRepository userRepo = new UserRepository();
        TicketRepo ticketRepo = new TicketRepo();
        TheaterRepo theaterRepo = new TheaterRepo();

        userRepo.getUserList().add(new User("1", "a@gmail.com"));
        userRepo.getUserList().add(new User("2", "b@gmail.com"));

        TheaterService theaterService = new TheaterService(theaterRepo, ticketRepo, userRepo);
        TheatherController theatherController = new TheatherController(theaterService);

        theatherController.createAtheather("1", "PVR", "123");

        List<Seat> seatList = List.of(
                new Seat("1", false),
                new Seat("2", false),
                new Seat("3", false),
                new Seat("4", false)
        );
        theatherController.addScreensAndSeats("1", "Main Screen", "1", seatList);

        // Booking Service
        SeatBookingStrategy strategy = new ExactMatchSeatBooking();
        TicketBookingService bookingService = new TicketBookingService(theaterRepo, ticketRepo, userRepo, strategy);
        TicketBookingController controller = new TicketBookingController(bookingService);

        System.out.println(controller.bookATicket("1", "1", "1", "1")); // true
        System.out.println(controller.bookATicket("1", "1", "1", "1")); // false
        System.out.println(controller.bookATicket("1", "1", "2", "2")); // true
    }
}

