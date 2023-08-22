package models;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private String name;
    private String address;
    private int capacity;
    private String phoneNo;
    private List<Entrance> entrances;
    private List<Vehicle> vehicles;
    private List<Spot> spots;
    private List<Attendant> attendants;

    public ParkingLot() {
    }

    public ParkingLot(String name, String address, int capacity, String phoneNo) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.phoneNo = phoneNo;
        this.entrances = new ArrayList<>();
        this.vehicles = new ArrayList<>();
        this.spots = new ArrayList<>();
        this.attendants = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public List<Entrance> getEntrances() {
        return entrances;
    }

    public void setEntrances(List<Entrance> entrances) {
        this.entrances = entrances;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Spot> getSpots() {
        return spots;
    }

    public void setSpots(List<Spot> spots) {
        this.spots = spots;
    }

    public List<Attendant> getAttendants() {
        return attendants;
    }

    public void setAttendants(List<Attendant> attendants) {
        this.attendants = attendants;
    }
}
