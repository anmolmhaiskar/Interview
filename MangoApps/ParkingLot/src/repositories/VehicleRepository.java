package repositories;

import enums.SizeCategory;
import models.Car;
import models.Entrance;
import models.Owner;
import models.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class VehicleRepository {
    private HashSet<String> registrationNos;
    private HashMap<String, List<String>> colorVehicleRegistrationNoMap;
    private List<Vehicle> vehicles;

    public VehicleRepository(){
        vehicles = new ArrayList<>();
        colorVehicleRegistrationNoMap = new HashMap<>();
        registrationNos = new HashSet<>();
    }


    public void createVehicle(String color, String state, SizeCategory type, Owner owner, Entrance entrance){
        Vehicle vehicle = new Vehicle(color, state, type, owner, entrance);
        addVehicle(vehicle);
    }

    public void createCar(String color, String state, SizeCategory type, Owner owner, Entrance entrance, String license, String company, int numberOfSeats){
        Car car = new Car(color, state, type, owner, entrance, license, company, numberOfSeats);
        addVehicle(car);
    }

    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);

        List<String> registrationNos = colorVehicleRegistrationNoMap.getOrDefault(vehicle.getRegistrationNo(), new ArrayList<String>());
        registrationNos.add(vehicle.getRegistrationNo());
        colorVehicleRegistrationNoMap.put(vehicle.getColor(), registrationNos);
    }

    public HashSet<String> getRegistrationNos(){
        return registrationNos;
    }

    public List<Vehicle> getVehicles(){
        return vehicles;
    }

    public List<String> getRegistrationNoByColor(String color){
        return colorVehicleRegistrationNoMap.get(color);
    }
}
