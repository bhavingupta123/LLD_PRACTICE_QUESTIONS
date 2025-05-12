package com.org.bookmyshow.repository;

import com.org.bookmyshow.model.*;

import java.util.*;

public class TheaterRepo {

    private final List<Theather> theatherList = new ArrayList<>();
    private final Map<String, List<Screen>> theaterScreenMap = new HashMap<>();

    public void createAtheather(String id, String name, String address) {
        Theather theather = new Theather(name, address, id);
        theatherList.add(theather);
    }

    public void addScreensAndSeats(String theaterId, String screenName, String screenId, List<Seat> seats) {
        Screen screen = new Screen(screenId, screenName, "Default Movie", seats);
        theaterScreenMap.computeIfAbsent(theaterId, k -> new ArrayList<>()).add(screen);
    }

    public List<Screen> getScreensByTheaterId(String theaterId) {
        return theaterScreenMap.get(theaterId);
    }
}
