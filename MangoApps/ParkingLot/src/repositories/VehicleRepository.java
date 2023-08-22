package repositories;

import enums.SizeCategory;
import models.*;

import java.util.*;

public class VehicleRepository {
    private HashSet<String> registrationNos;
    private HashMap<String, List<String>> colorVehicleRegistrationNoMap;
    private List<Vehicle> vehicles;
    private HashMap<String, Vehicle> vehicleRegistrationNoMap;

    public VehicleRepository(){
        vehicles = new ArrayList<>();
        colorVehicleRegistrationNoMap = new HashMap<>();
        registrationNos = new HashSet<>();
        vehicleRegistrationNoMap = new HashMap<>();
    }


    public Vehicle createVehicle(String vehicleType, String color, String state, SizeCategory type, Owner owner, Entrance entrance){
        Vehicle vehicle = vehicleFactory(vehicleType, color, state, type, owner, entrance, null, 4);
        return vehicle;
    }

    public Vehicle createVehicle(String vehicleType, String color, String state, SizeCategory type, Owner owner, Entrance entrance, String company, int numberOfSeats){
        vehicleType = vehicleType.toLowerCase();
        Vehicle vehicle = vehicleFactory(vehicleType, color, state, type, owner, entrance, company, numberOfSeats);
        return vehicle;
    }

    public Car createCar(String color, String state, SizeCategory type, Owner owner, Entrance entrance, String company, int numberOfSeats){
        Car car = (Car) vehicleFactory("car", color, state, type, owner, entrance, company, numberOfSeats);
        addVehicle(car);
        return car;
    }

    public Vehicle vehicleFactory(String vehicleType, String color, String state, SizeCategory type, Owner owner, Entrance entrance, String company, int numberOfSeats){
        Vehicle vehicle;
        switch (vehicleType) {
            case "car" -> vehicle = new Car(color, state, type, owner, entrance, company, numberOfSeats);
            default -> vehicle = new Vehicle(color, state, type, owner, entrance);
        };
        addVehicle(vehicle);
        return vehicle;
    }

    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);

        List<String> registrationNos = colorVehicleRegistrationNoMap.getOrDefault(vehicle.getRegistrationNo(), new ArrayList<String>());
        registrationNos.add(vehicle.getRegistrationNo());
        colorVehicleRegistrationNoMap.put(vehicle.getColor().toLowerCase(), registrationNos);
        vehicleRegistrationNoMap.put(vehicle.getRegistrationNo(), vehicle);
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

    public Vehicle getVehicleByRegistrationNo(String registrationNo){
        return vehicleRegistrationNoMap.getOrDefault(registrationNo, null);
    }

    public void addTicket(Vehicle vehicle, Ticket ticket) {
        vehicle.addTicket(ticket);
    }

    public Ticket getLastTicket(Vehicle vehicle) {
        List<Ticket> tickets = vehicle.getTickets();
        if(tickets == null || tickets.isEmpty())
            return null;
        return tickets.get(tickets.size()-1);
    }
}
