package models;

import enums.SizeCategory;

public class Car extends Vehicle{
//    int id;
    private String company;
    private int numberOfSeats;

    public Car() {
        this.company = null;
        this.numberOfSeats = 4;
    }

    public Car(String color, String state, SizeCategory type, Owner owner, Entrance entrance, String company, int numberOfSeats) {
        super(color, state, type, owner, entrance);
        this.company = company;
        this.numberOfSeats = numberOfSeats;
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
