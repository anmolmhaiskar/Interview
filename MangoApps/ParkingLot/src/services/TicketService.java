package services;

import exceptions.SpotNotAvailableException;
import exceptions.TicketNotFoundException;
import exceptions.TicketNotGeneratedException;
import exceptions.VehicleIsNotPresentException;
import models.Payment;
import models.Spot;
import models.Ticket;
import models.Vehicle;
import repositories.TicketRepository;
import utils.TicketFactory;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class TicketService {

    public static TicketRepository ticketRepository = TicketFactory.getInstance();
    public static Ticket createTicket(Vehicle vehicle, Spot spot) {
        if(vehicle == null || spot == null){
            throw new TicketNotGeneratedException(String.format("Failed to generate the ticket for the vehicle %s for the spot %s", vehicle, spot));
        }
        Ticket ticket = ticketRepository.createTicket(vehicle, spot);
        VehicleService.addTicket(vehicle, ticket);
        return ticket;
    }

    public static Ticket updateCost(Ticket ticket){
        ticket.setEnd_time(new Date());
        double amount = calculateCost(ticket);
        ticket.setAmount(amount);
        return ticket;
    }

    public static double calculateCost(Ticket ticket) {
        long hours = TimeUnit.MILLISECONDS.toHours(ticket.getEnd_time().getTime() - ticket.getStart_time().getTime());
        double totalCost = hours * ticket.getSpot().getCostPerHour();
        return totalCost;
    }

    public static int getTicketNoByRegistrationNo(String registrationNo){
        Vehicle vehicle = VehicleService.getVehicleByRegistrationNo(registrationNo);
        Ticket ticket = ticketRepository.getTicketByVehicle(vehicle);
        if(ticket == null){
            throw new TicketNotFoundException(String.format("There is no ticket present for the given registrationNo %s", registrationNo));
        }
        return ticket.getTicketNo();
    }

    public static List<Integer> getTicketNoByVehicleColor(String color){
        color = color.toLowerCase();
        List<Ticket> tickets = ticketRepository.getTicketNoByColor(color);
        if(tickets==null || tickets.isEmpty()){
            throw new TicketNotFoundException(String.format("There are no tickets available with the vehicle %s color", color));
        }
        return tickets.stream().map(ticket -> ticket.getTicketNo()).collect(Collectors.toList());
    }

    public static void setPayment(Ticket ticket,Payment payment) {
        ticketRepository.setPayment(ticket, payment);
    }
}
