package com.org.bookmyshow.repository;

import com.org.bookmyshow.model.Ticket;
import com.org.bookmyshow.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicketRepo {

    private Map<String, User> stringUserMap = new HashMap<>();

    List<Ticket> ticketList = new ArrayList<>();

    public List<Ticket> getTicketList() {
        return ticketList;
    }
}
