package services;

import enums.SizeCategory;
import exceptions.SpotNotAvailableException;
import exceptions.VehicleIsNotPresentException;
import models.Spot;
import models.Vehicle;
import repositories.SpotRepository;
import utils.SpotFactory;

import java.util.List;

public class SpotService {

    private static SpotRepository spotRepository = SpotFactory.getInstance() ;
    public static void initializeSpots(){
        spotRepository.initializeSpots(100);
    }

    public static void initializeSpots(int numberOfSpots) {
        spotRepository.initializeSpots(numberOfSpots);
    }

    public static Spot findNearestSpot(Vehicle vehicle) {
        if(vehicle == null){
            throw new VehicleIsNotPresentException("Invalid Vehicle. Value of vehicle is null");
        }
        Spot spot = spotRepository.getNearestSpot(vehicle.getEntrance().getGateNo(), vehicle.getSize());
        if(spot == null)
            throw new SpotNotAvailableException(String.format("There are no free spots available in the parking lot with the %s spot type", vehicle.getSize()));
        return spot;
    }

    public static void setVehicleOnSpot(Spot spot, Vehicle vehicle) {
        spotRepository.setVehicleOnSpot(spot, vehicle);
    }

    public static void vacateSpot(Spot spot) {
        if(spot == null){
            throw new SpotNotAvailableException("Cannot vacate spot. Spot value is null or not available");
        }
        spotRepository.vacateSpot(spot);
    }

    public static List<Spot> getSpots() {
        return spotRepository.getSpots();
    }
}
