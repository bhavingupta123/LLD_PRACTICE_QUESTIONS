package org.example.parking;

import org.example.parking.controller.ParkingSpotAllocator;
import org.example.parking.controller.ParkingSystem;
import org.example.parking.repository.facility.ParkingRepo;
import org.example.parking.repository.facility.ParkingSpotType;
import org.example.parking.repository.ticket.TicketRepo;
import org.example.parking.service.ParkingSystemService;
import org.example.parking.service.TicketIssuerService;

public class Main {

    public static void main(String[] args) {
        ParkingRepo parkingRepo = new ParkingRepo();

        //create parking system
        // add parking spots
        ParkingSystemService parkingSystemService = new ParkingSystemService(parkingRepo);

        ParkingSystem parkingSystem = new ParkingSystem(parkingSystemService);
        parkingSystem.addParkingSpot();


        // allocate a spot to car
        TicketRepo ticketRepo = new TicketRepo();

        TicketIssuerService service = new TicketIssuerService();

        ParkingSpotAllocator parkingSpotAllocator = new ParkingSpotAllocator(service, ticketRepo, parkingRepo);
        parkingSpotAllocator.occupySpot(ParkingSpotType.FOUR_WHEELER);
    }
}
