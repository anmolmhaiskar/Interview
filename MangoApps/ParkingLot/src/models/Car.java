package models;

import enums.SizeCategory;

public class Car extends Vehicle{
//    int id;
    private String license;
    private String company;
    private int numberOfSeats;

    public Car() {
        this.license = null;
        this.company = null;
        this.numberOfSeats = 4;
    }

    public Car(String color, String state, SizeCategory type, Owner owner, Entrance entrance, String license, String company, String numberPlate, int numberOfSeats) {
        super(color, state, type, owner, entrance);
        this.license = license;
        this.company = company;
        this.numberOfSeats = numberOfSeats;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
