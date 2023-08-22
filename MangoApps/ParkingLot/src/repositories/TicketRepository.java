package repositories;

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
        vehicleColoredTicketMap = new HashMap<String, List<Ticket>>();
    }

    public Ticket createTicket(Vehicle vehicle, Spot spot){
        Ticket ticket = new Ticket(vehicle, spot);
        addTicket(ticket);
        return ticket;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket){
        addTicket(ticket, null);
    }

    public void addTicket(Ticket ticket, Vehicle vehicle){
        tickets.add(ticket);
        if(vehicle!=null){
            vehicleTicketMap.put(vehicle, ticket);
        }

        List<Ticket> colorTickets = vehicleColoredTicketMap.getOrDefault(vehicle.getColor(), new ArrayList<Ticket>());
        colorTickets.add(ticket);
        vehicleColoredTicketMap.put(vehicle.getColor(), colorTickets);
    }

    public Ticket getTicketByVehicle(Vehicle vehicle){
        return vehicleTicketMap.get(vehicle);
    }

    public List<Ticket> getTicketNoByColor(String color){
        return vehicleColoredTicketMap.get(color);
    }
}
