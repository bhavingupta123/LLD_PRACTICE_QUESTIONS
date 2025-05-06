package org.example.parking.controller;

import org.example.parking.repository.facility.ParkingRepo;
import org.example.parking.repository.facility.ParkingSpotType;
import org.example.parking.repository.ticket.TicketRepo;
import org.example.parking.service.TicketIssuerService;

public class ParkingSpotAllocator {

    TicketIssuerService service;
    TicketRepo ticketRepo;
    ParkingRepo parkingRepo;

    public ParkingSpotAllocator(TicketIssuerService service, TicketRepo ticketRepo,ParkingRepo parkingRepo){
        this.service = service;
        this.ticketRepo = ticketRepo;
        this.parkingRepo = parkingRepo;
    }

    public void occupySpot(ParkingSpotType type){
        service.issueTicket(type, ticketRepo, parkingRepo);
    };
    public void emptySpot(){};

}
