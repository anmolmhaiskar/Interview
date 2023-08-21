package models;

import enums.ModeOfPayment;
import enums.PaymentStatus;

public class Payment {
    int id;
    Ticket ticket;
    ModeOfPayment mode;
    PaymentStatus paymentStatus;
    double amount;
    Owner owner;
    int numberOfRetries;

    public Payment(Ticket ticket, ModeOfPayment mode, PaymentStatus paymentStatus, double amount, Owner owner) {
        setPaymentId();
        this.ticket = ticket;
        this.mode = mode;
        this.paymentStatus = paymentStatus;
        this.amount = amount;
        this.owner = owner;
        this.numberOfRetries = 0;
    }

    //TODO:generate id
    private void setPaymentId() {
    }

    public int getId() {
        return id;
    }

    public void setPaymentId(int id) {
        this.id = id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public ModeOfPayment getMode() {
        return mode;
    }

    public void setMode(ModeOfPayment mode) {
        this.mode = mode;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public int getNumberOfRetries() {
        return numberOfRetries;
    }

    public void setNumberOfRetries(int numberOfRetries) {
        this.numberOfRetries = numberOfRetries;
    }
}
