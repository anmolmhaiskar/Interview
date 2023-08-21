package models;

import Utils.IdGeneratorUtil;
import enums.ModeOfPayment;
import enums.PaymentStatus;

public class Payment {
    private int id;
    private Ticket ticket;
    private ModeOfPayment mode;
    private PaymentStatus paymentStatus;
    private double amount;
    private Owner owner;
    private int numberOfRetries;

    public Payment(Ticket ticket, ModeOfPayment mode, PaymentStatus paymentStatus, double amount, Owner owner) {
        this.id = IdGeneratorUtil.generateID(this);
        this.ticket = ticket;
        this.mode = mode;
        this.paymentStatus = paymentStatus;
        this.amount = amount;
        this.owner = owner;
        this.numberOfRetries = 0;
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
