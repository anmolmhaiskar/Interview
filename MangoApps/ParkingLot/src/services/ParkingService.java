package services;

import models.ParkingLot;
import models.Spot;

import java.util.ArrayList;
import java.util.List;

public class ParkingService {
    public List<Spot> spots;

    private ParkingService(List<Spot> spots) {
        this.spots = new ArrayList<>();
    }

}
