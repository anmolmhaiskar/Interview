package models;

import Utils.IdGeneratorUtil;
import enums.SizeCategory;

import java.util.random.RandomGenerator;

public class Vehicle {
    private int id;
    private String color;
    private String state;
    private String registrationNo;
    private SizeCategory size;
    private Owner owner;
    private Entrance entrance;

    public Vehicle() {
        this.id = IdGeneratorUtil.generateID(this);
        this.color = "white";
        setRegistrationNo();
        this.size= SizeCategory.MEDIUM;
        this.owner = null;
    }

    public Vehicle(String color,String state, SizeCategory type, Owner owner, Entrance entrance) {
        this.color = color;
        this.state = state;
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

    public String getRegistrationNo() {
        return registrationNo;
    }

    //TODO: Set registration no to every newly created vehicle
    public void setRegistrationNo() {
        this.registrationNo = IdGeneratorUtil.generateRegistrationNo(5, this.state);
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
