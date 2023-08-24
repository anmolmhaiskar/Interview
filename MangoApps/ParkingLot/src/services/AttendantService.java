package services;

import enums.ModeOfPayment;
import exceptions.SpotNotAvailableException;
import exceptions.TicketNotGeneratedException;
import exceptions.VehicleIsNotPresentException;
import models.*;
import repositories.AttendantRepository;
import utils.AttendantFactory;

import java.util.List;

public class AttendantService {

    public static AttendantRepository attendantRepository = AttendantFactory.getInstance();

    public static void attendantGenerator(){
        attendantRepository.attendantGenerator();
    }

    public static List<Attendant> getAttendants(){
        return attendantRepository.getAttendants();
    }

    public static void receiveVehicle(Vehicle vehicle){
        if(vehicle == null){
            throw new VehicleIsNotPresentException("Invalid Vehicle. Value of vehicle is null");
        }
        Spot spot = SpotService.findNearestSpot(vehicle);
        Ticket ticket = TicketService.createTicket(vehicle, spot);
        ParkingService.parkVehicle(vehicle, spot, ticket);
    }

    public static Payment releaseSpot(Spot spot, ModeOfPayment modeOfPayment){
        if(spot == null){
            throw new SpotNotAvailableException("Invalid spot. Spot value is null or not present");
        }
        if(spot.getVehicle() == null){
            throw new VehicleIsNotPresentException("Invalid vehicle. Vehicle value is null or not present");
        }
        Ticket ticket = TicketService.updateCost(VehicleService.getLastTicket(spot.getVehicle()));
        Payment payment = PaymentService.makePayment(ticket, modeOfPayment);
        return payment;
    }
}
