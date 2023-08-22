package services;

import enums.ModeOfPayment;
import models.*;
import utils.SpotFactory;

import java.util.List;

public class ParkingService {
    public static void parkVehicle(Vehicle vehicle, Spot spot, Ticket ticket){
        SpotService.setVehicleOnSpot(spot, vehicle);
        VehicleService.addTicket(vehicle, ticket);
    }

    public static void releaseSpot(Spot spot){
        SpotService.vacateSpot(spot);
    }

}
