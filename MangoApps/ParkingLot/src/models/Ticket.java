package models;

import Utils.IdGeneratorUtil;

import java.util.Date;

public class Ticket {
    private int ticketNo;
    private Vehicle vehicle;
    private Date start_time;
    private Date end_time;
    private Spot spot;
    private double amount;
    private Payment payment;

    public Ticket(Vehicle vehicle, Spot spot) {
        this.ticketNo = IdGeneratorUtil.generateID(this);
        this.vehicle = vehicle;
        this.spot = spot;
        this.amount = 0.0;
        this.start_time = new Date();
        this.payment = null;
    }

    public int getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(int ticketNo) {
        this.ticketNo = ticketNo;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
