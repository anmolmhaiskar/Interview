package repositories;

import models.Payment;
import models.Spot;
import models.Ticket;
import models.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TicketRepository {
    HashMap<Vehicle, Ticket> vehicleTicketMap;
    List<Ticket> tickets;

    HashMap<String, List<Ticket>> vehicleColoredTicketMap;

    public TicketRepository(){
        vehicleTicketMap = new HashMap<>();
        tickets = new ArrayList<>();
        vehicleColoredTicketMap = new HashMap<>();
    }

    public Ticket createTicket(Vehicle vehicle, Spot spot){
        Ticket ticket = new Ticket(vehicle, spot);
        addTicket(ticket, vehicle);
        return ticket;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket){
        tickets.add(ticket);
    }

    public void addTicket(Ticket ticket, Vehicle vehicle){
        tickets.add(ticket);
        if(vehicle!=null){
            vehicleTicketMap.put(vehicle, ticket);
        }

        List<Ticket> colorTickets = vehicleColoredTicketMap.getOrDefault(vehicle.getColor().toLowerCase(), new ArrayList<Ticket>());
        colorTickets.add(ticket);
        vehicleColoredTicketMap.put(vehicle.getColor().toLowerCase(), colorTickets);
    }

    public Ticket getTicketByVehicle(Vehicle vehicle){
        return vehicleTicketMap.get(vehicle);
    }

    public List<Ticket> getTicketNoByColor(String color){
        return vehicleColoredTicketMap.get(color);
    }

    public void setPayment(Ticket ticket, Payment payment) {
        ticket.setPayment(payment);
    }
}
