package repositories;

import exceptions.OwnerAlreadyExistException;
import models.Owner;
import models.Payment;
import models.Ticket;
import models.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class OwnerRepository {

    private List<Owner> owners;

    public OwnerRepository(){
        this.owners = new ArrayList<>();
    }

    public Owner createOwner(String name, String phoneNo, String gender, int age){
        Owner owner = checkIfAlreadyExist(name, phoneNo, gender, age);
        if(owner == null){
            owner = new Owner(name, phoneNo, gender, age);
            addOwners(owner);
        }
        else throw new OwnerAlreadyExistException("This owner already exists");
        return owner;
    }

    public Owner checkIfAlreadyExist(String name, String phoneNo, String gender, int age){
        for(Owner owner : owners){
            if(owner.getName().equals(name) && owner.getPhoneNo().equals(phoneNo) && owner.getGender().equals(gender) && owner.getAge() == age){
                return owner;
            }
        }
        return null;
    }
    public void addOwners(Owner owner) {
        owners.add(owner);
    }
    public List<Owner> getOwners() {
        return owners;
    }

    public void addVehicles(Owner owner, Vehicle vehicle){
        owner.addVehicles(vehicle);
    }

    public void addPayments(Owner owner, Payment payment){
        owner.addPayments(payment);
    }
}
