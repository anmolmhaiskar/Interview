package services;

import enums.SizeCategory;
import exceptions.*;
import models.*;
import repositories.VehicleRepository;
import utils.VehicleFactory;

import java.util.List;

public class VehicleService {

    public static VehicleRepository vehicleRepository = VehicleFactory.getInstance();


    public static Vehicle createVehicle(String vehicleType, String color, String state, SizeCategory type, Owner owner, Entrance entrance){
        validateParameters(color, state, type, owner, entrance);
        Vehicle vehicle = vehicleRepository.createVehicle(vehicleType, color, state, type, owner, entrance);
        return vehicle;
    }

    public static Vehicle createVehicle(String vehicleType, String color, String state, SizeCategory type, Owner owner, Entrance entrance, String company, int numberOfSeats){
        validateParameters(color, state, type, owner, entrance);
        Vehicle vehicle = vehicleRepository.createVehicle(vehicleType, color, state, type, owner, entrance, color, numberOfSeats);
        return vehicle;
    }

    public static Car createCar(String color, String state, SizeCategory type, Owner owner, Entrance entrance, String company, int numberOfSeats){
        validateParameters(color, state, type, owner, entrance);
        Car car = (Car) vehicleRepository.createCar(color, state, type, owner, entrance, company, numberOfSeats);
        return car;
    }

    public static List<String> getRegistrationOfVehicleByColor(String color){
        color = color.toLowerCase();
        List<String> registrationNos = vehicleRepository.getRegistrationNoByColor(color);
        if (registrationNos!=null && !registrationNos.isEmpty()){
            return registrationNos;
        }
        else throw new VehicleIsNotPresentException(String.format("There are no vehicles of %s present at parkingLot", color));
    }

    public static Vehicle getVehicleByRegistrationNo(String registrationNo){
        Vehicle vehicle = vehicleRepository.getVehicleByRegistrationNo(registrationNo);
        if(vehicle == null){
            throw new VehicleIsNotPresentException(String.format("There is no vehicle present with the given registration no: %s", registrationNo));
        }
        return vehicle;
    }

    public static void addTicket(Vehicle vehicle, Ticket ticket) {
        vehicleRepository.addTicket(vehicle, ticket);
    }

    public static Ticket getLastTicket(Vehicle vehicle) {
        Ticket lastTicket = vehicleRepository.getLastTicket(vehicle);
        if (lastTicket == null){
            throw new TicketNotFoundException(String.format("There is no ticket present or generated for the vehicle", vehicle.getRegistrationNo()));
        }
        return lastTicket;
    }
    public static void validateParameters(String color, String state, SizeCategory type, Owner owner, Entrance entrance){
        if(color == null || color.isEmpty()){
            throw new InvalidColorValueException(String.format("Invalid value of color is provided"));
        }

        if(type == null){
            throw new InvalidSizeCategoryException(String.format("Invalid Size of the vehicle is provided"));
        }

        if(state == null || state.isEmpty()){
            throw new InvalidStateValueException(String.format("Invalid value of state is provided"));
        }

        if(owner == null){
            throw new OwnerNotFoundException(String.format("Owner is not assigned to the vehicle"));
        }

        if(entrance == null){
            throw new EntranceNotFoundException(String.format("Invalid entrance value is assigned to vehicle"));
        }
    }

    public static List<Vehicle> getVehicles() {
        return vehicleRepository.getVehicles();
    }
}
