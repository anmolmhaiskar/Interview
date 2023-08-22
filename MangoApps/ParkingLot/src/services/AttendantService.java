package services;

import enums.ModeOfPayment;
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

    public static void releaseSpot(Spot spot, ModeOfPayment modeOfPayment){
        ParkingService.releaseSpot(spot);
        Ticket ticket = TicketService.updateCost(VehicleService.getLastTicket(spot.getVehicle()));
        Payment payment = PaymentService.makePayment(ticket, modeOfPayment);
    }
}
