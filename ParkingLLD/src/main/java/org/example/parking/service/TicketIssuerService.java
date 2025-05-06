package org.example.parking.service;

import org.example.parking.model.TicketModel;
import org.example.parking.repository.facility.ParkingRepo;
import org.example.parking.repository.facility.ParkingSpotType;
import org.example.parking.repository.ticket.TicketRepo;
import org.example.parking.service.allocation.FloorByFloorSpotAllocator;
import org.example.parking.service.allocation.ParkingSpotAllocator;

import java.time.LocalDateTime;
import java.util.UUID;

public class TicketIssuerService {
    TicketRepo ticketRepo;
    ParkingRepo parkingRepo;

    public void issueTicket(ParkingSpotType parkingSpotType, TicketRepo ticketRepo, ParkingRepo parkingRepo){
        TicketModel ticketModel = new TicketModel();
        ticketModel.setIssuedAt(LocalDateTime.now().toString());
        ticketModel.setPaid(false);
        String ticketId = UUID.randomUUID().toString();

        // fetch parking spot
        ParkingSpotAllocator allocator = new FloorByFloorSpotAllocator(parkingRepo);
        String parkingId = allocator.allocateSpot();
        System.out.println("parking id: "+ parkingId);
        ticketRepo.addtoMap(ticketId,  parkingId);
        ticketRepo.ticketToList(ticketModel);

        // mark spot as occupied
        parkingRepo.setParkingSpotAsOccupied(parkingId);

    };
    public void cancelTicket(){};

    public void checkoutTicket(String ticketId){
        // mark ticket as paid
        TicketModel model = ticketRepo.fetchTicket(ticketId);
        // mark spot as free
        String parkingId = model.getParkingId();
        parkingRepo.setParkingSpotAsFree(parkingId);
        // update cost of ticket
        model.setCost(100);
        model.setPaid(true);
    };
}
