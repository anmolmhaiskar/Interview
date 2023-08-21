package models;

import enums.SizeCategory;

public abstract class Vehicle {
//    int id;
    String color;
    long registrationNo;
    SizeCategory size;
    Owner owner;
    Entrance entrance;

    public Vehicle() {
        this.color = "white";
        setRegistrationNo();
        this.size= SizeCategory.MEDIUM;
        this.owner = null;
    }

    public Vehicle(Owner owner) {
        this.color = "white";
        setRegistrationNo();
        this.size= SizeCategory.MEDIUM;
        this.owner = owner;
    }

    public Vehicle(String color, SizeCategory type, Owner owner, Entrance entrance) {
        this.color = color;
        setRegistrationNo();
        this.size = type;
        this.owner = owner;
        this.entrance = entrance;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getRegistrationNo() {
        return registrationNo;
    }

    //TODO: Set registration no to every newly created vehicle
    public void setRegistrationNo() {
        this.registrationNo = registrationNo;
    }

    public SizeCategory getSize() {
        return size;
    }

    public void setSize(SizeCategory type) {
        this.size = type;
    }

    public Entrance getEntrance() {
        return entrance;
    }

    public void setEntrance(Entrance entrance) {
        this.entrance = entrance;
    }
}
