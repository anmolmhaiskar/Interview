package models;

import enums.SizeCategory;

public class Car extends Vehicle{
//    int id;
    String license;
    String company;
    String numberPlate;
    int numberOfSeats;

    public Car() {
        this.license = null;
        this.company = null;
        this.numberPlate = null;
        this.numberOfSeats = 4;
    }

    public Car(String color, SizeCategory type, Owner owner, Entrance entrance, String license, String company, String numberPlate, int numberOfSeats) {
        super(color, type, owner, entrance);
        this.license = license;
        this.company = company;
        this.numberPlate = numberPlate;
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

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
