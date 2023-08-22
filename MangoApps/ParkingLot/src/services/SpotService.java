package services;

import enums.SizeCategory;
import exceptions.SpotNotAvailableException;
import models.Spot;
import models.Vehicle;
import repositories.SpotRepository;
import utils.SpotFactory;

public class SpotService {

    private static SpotRepository spotRepository = SpotFactory.getInstance() ;
    public static void initializeSpots(){
        spotRepository.initializeSpots(100);
    }

    public static void initializeSpots(int numberOfSpots) {
        spotRepository.initializeSpots(numberOfSpots);
    }

    public static Spot findNearestSpot(Vehicle vehicle) {
        Spot spot = spotRepository.getNearestSpot(vehicle.getEntrance().getGateNo(), vehicle.getSize());
        if(spot == null)
            throw new SpotNotAvailableException(String.format("There are no free spots available in the parking lot with the %s spot type", vehicle.getSize()));
        return spot;
    }

    public static void setVehicleOnSpot(Spot spot, Vehicle vehicle) {
        spotRepository.setVehicleOnSpot(spot, vehicle);
    }

    public static void vacateSpot(Spot spot) {
        spotRepository.vacateSpot(spot);
    }
}
