package org.example.parking.service;

import org.example.parking.controller.ParkingSystem;
import org.example.parking.model.ParkingModel;
import org.example.parking.repository.facility.ParkingRepo;
import org.example.parking.repository.facility.ParkingSpotType;

public class ParkingSystemService {

    ParkingRepo parkingRepo;

    public ParkingSystemService(ParkingRepo parkingRepo){
        this.parkingRepo = parkingRepo;
    }
    public void addParkingSpot(){
        ParkingModel parkingModel = new ParkingModel();
        parkingModel.setAvailable(true);
        parkingModel.setParkingSpotType(ParkingSpotType.TWO_WHEELER);
        parkingModel.setFloorId("1");
        parkingModel.setLabel("101");
        parkingModel.setId("T 123");

        ParkingModel parkingModel2 = new ParkingModel();
        parkingModel2.setAvailable(true);
        parkingModel2.setParkingSpotType(ParkingSpotType.FOUR_WHEELER);
        parkingModel2.setFloorId("2");
        parkingModel2.setLabel("201");
        parkingModel2.setId("F 123");

        parkingRepo.addParkingSpot(parkingModel);
        parkingRepo.addParkingSpot(parkingModel2);
    };

    public void deleteParkingSpot(String parkingId){
        parkingRepo.deleteParkingSpot(parkingId);
    };
}
