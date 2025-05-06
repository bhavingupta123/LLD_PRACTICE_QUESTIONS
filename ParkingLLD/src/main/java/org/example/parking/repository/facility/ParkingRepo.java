package org.example.parking.repository.facility;

import org.example.parking.model.ParkingModel;

import java.util.ArrayList;
import java.util.List;

public class ParkingRepo {

    List<ParkingModel> parkingModelList = new ArrayList<>();

    public void addParkingSpot(ParkingModel parkingModel){
        parkingModelList.add(parkingModel);
    }

    public void deleteParkingSpot(String parkingId){
    }

    public List<ParkingModel> getParkingModelList() {
        return parkingModelList;
    }

    public void setParkingSpotAsOccupied(String parkingSpotId){
        // mark the parking spot as occupied

    }

    public void setParkingSpotAsFree(String parkingSpotId){
        // mark the parking spot as occupied

    }
}
