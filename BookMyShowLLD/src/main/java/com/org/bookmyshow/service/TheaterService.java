package com.org.bookmyshow.service;

import com.org.bookmyshow.model.Seat;
import com.org.bookmyshow.repository.TheaterRepo;
import com.org.bookmyshow.repository.TicketRepo;
import com.org.bookmyshow.repository.UserRepository;

import java.util.List;

public class TheaterService {

    private TheaterRepo theaterRepo;
    private TicketRepo ticketRepo;
    private UserRepository userRepository;

    public TheaterService(TheaterRepo theaterRepo, TicketRepo ticketRepo, UserRepository userRepository){
        this.theaterRepo = theaterRepo;
        this.ticketRepo = ticketRepo;
        this.userRepository = userRepository;
    }

    public void createAtheather(String theatherid, String name, String address){
        theaterRepo.createAtheather(theatherid, name, address);
    }

    public void addScreensAndSeats(String theaterId, String screenName, String screenId, List<Seat> seats){
        theaterRepo.addScreensAndSeats(theaterId, screenName, screenId ,seats);
    }
}
