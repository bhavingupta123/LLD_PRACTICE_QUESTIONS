package com.org.bookmyshow.controllers;

import com.org.bookmyshow.model.Seat;
import com.org.bookmyshow.service.TheaterService;

import java.util.List;

public class TheatherController {

    private TheaterService theaterService;

    public TheatherController(TheaterService theaterService){
        this.theaterService = theaterService;
    }


    public void createAtheather(String theatherid, String name, String address){
        theaterService.createAtheather(theatherid, name, address);
    }

    public void addScreensAndSeats(String theaterId, String screenName, String screenId, List<Seat> seats){
        theaterService.addScreensAndSeats(theaterId, screenName, screenId, seats);
    }
}
