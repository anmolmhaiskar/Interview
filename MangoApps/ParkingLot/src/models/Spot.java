package models;

import enums.SizeCategory;

public class Spot {
//    private int id;
    private Vehicle vehicle;
    SizeCategory size;
    double costPerHour;
    int xCoordinate;
    int yCoordinate;

    public Spot() {
    }

    public Spot(SizeCategory size, double costPerHour, int xCoordinate, int yCoordinate) {
        this.size = size;
        this.costPerHour = costPerHour;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public SizeCategory getSize() {
        return size;
    }

    public void setSize(SizeCategory size) {
        this.size = size;
    }

    public double getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(double costPerHour) {
        this.costPerHour = costPerHour;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public void vacateSpot(){
        this.vehicle = null;
    }

    public boolean isAvailable(){
        return this.vehicle == null;
    }
}
