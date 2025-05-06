package org.example.parking.controller;

import org.example.parking.service.ParkingSystemService;

public class ParkingSystem {

    ParkingSystemService parkingSystemService;

    public ParkingSystem(ParkingSystemService parkingSystemService){
        this.parkingSystemService= parkingSystemService;
    }

    public void addParkingSpot(){
        parkingSystemService.addParkingSpot();
    };
    public void deleteParkingSpot(String spotId){
        parkingSystemService.deleteParkingSpot(spotId);
    };
}
