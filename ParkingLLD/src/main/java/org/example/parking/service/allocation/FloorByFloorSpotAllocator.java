package org.example.parking.service.allocation;

import org.example.parking.model.ParkingModel;
import org.example.parking.repository.facility.ParkingRepo;
import org.example.parking.repository.facility.ParkingSpotType;

public class FloorByFloorSpotAllocator implements ParkingSpotAllocator{
    ParkingRepo parkingRepo;

    public FloorByFloorSpotAllocator(ParkingRepo parkingRepo){
        this.parkingRepo =parkingRepo;
    }

    @Override
    public String allocateSpot() {

        for (ParkingModel model: parkingRepo.getParkingModelList()
             ) {
            System.out.println("model:" + model.getId() + model.getParkingSpotType());
            if(model.isAvailable() && model.getParkingSpotType()== ParkingSpotType.FOUR_WHEELER){
                return model.getId();
            }
        }

        return null;
    }
}
