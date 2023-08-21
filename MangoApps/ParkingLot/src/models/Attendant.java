package models;

import Utils.IdGeneratorUtil;

public class Attendant {
    private int id;
    private String name;
    private int gateNo;
    private String emailId;
    private String phoneNo;
    private String gender;
    private int age;

    public Attendant() {
    }

    public Attendant(String name, int gateNo, String emailId, String phoneNo, String gender, int age) {
        this.id = IdGeneratorUtil.generateID(this);
        this.name = name;
        this.gateNo = gateNo;
        this.emailId = emailId;
        this.phoneNo = phoneNo;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGateNo() {
        return gateNo;
    }

    public void setGateNo(int gateNo) {
        this.gateNo = gateNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
