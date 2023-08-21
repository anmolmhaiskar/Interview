package repositories;

import models.Owner;
import models.Payment;
import models.Ticket;
import models.Vehicle;

import java.util.List;

public class OwnerRepository {

    private List<Owner> owners;


    public Owner createOwner(String name, String phoneNo, String gender, int age){
        Owner owner = new Owner(name, phoneNo, gender, age);
        return owner;
    }

    public void addOwners(Owner owner) {
        owners.add(owner);
    }
    public List<Owner> getOwners() {
        return owners;
    }

    public void addTicket(Owner owner, Ticket ticket){
        owner.addTickets(ticket);
    }

    public void addVehicles(Owner owner, Vehicle vehicle){
        owner.addVehicles(vehicle);
    }

    public void addPayments(Owner owner, Payment payment){
        owner.addPayments(payment);
    }
}
