package com.org.bookmyshow.model;

import java.util.List;

public class Screen {

    String id, name, movieName;
    List<Seat> seats;

    public Screen(String id, String name, String movieName, List seats) {
        this.id = id;
        this.name = name;
        this.movieName = movieName;
        this.seats = seats;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
