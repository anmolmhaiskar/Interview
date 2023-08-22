package services;

import enums.ModeOfPayment;
import exceptions.TicketNotGeneratedException;
import models.Payment;
import models.Spot;
import models.Ticket;
import models.Vehicle;
import repositories.AttendantRepository;
import utils.AttendantFactory;

public class AttendantService {

    public static AttendantRepository attendantRepository = AttendantFactory.getInstance();

    public static void attendantGenerator(){
        attendantRepository.attendantGenerator();
    }

    public static void receiveVehicle(Vehicle vehicle){
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
