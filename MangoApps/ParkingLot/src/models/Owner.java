package models;

import utils.IdGeneratorUtil;

import java.util.ArrayList;
import java.util.List;

public class Owner {
    private int id;
    private String name;
    private String phoneNo;
    private String gender;
    private int age;
    private List<Vehicle> vehicles;
    private List<Payment> payments;

    public Owner(String name, String phoneNo, String gender, int age) {
        this.id = IdGeneratorUtil.generateID(this);
        this.name = name;
        this.phoneNo = phoneNo;
        this.gender = gender;
        this.age = age;
        this.vehicles = new ArrayList<>();
        this.payments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicles(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void addPayments(Payment payment) {
        payments.add(payment);
    }
}
