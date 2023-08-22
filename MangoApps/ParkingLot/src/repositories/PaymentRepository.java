package repositories;

import enums.ModeOfPayment;
import enums.PaymentStatus;
import models.Owner;
import models.Payment;
import models.Ticket;

import java.util.ArrayList;
import java.util.List;

public class PaymentRepository {
    List<Payment> payments;
    public PaymentRepository(){
        payments = new ArrayList<>();
    }

    public Payment makePayment(Ticket ticket, ModeOfPayment mode, PaymentStatus paymentStatus, double amount, Owner owner){
        Payment payment = new Payment(ticket, mode, paymentStatus, amount, owner);
        addPayment(payment);
        payment.setPaymentStatus(PaymentStatus.COMPLETED);
        return payment;
    }

    public void addPayment(Payment payment) {
        payments.add(payment);
    }

    public void updatePaymentStatus(Payment payment, PaymentStatus paymentStatus){
        payment.setPaymentStatus(paymentStatus);
    }

    public Payment getPayment(int id){
        for(Payment payment : payments)  {
            if(payment.getId() == id){
                return payment;
            }
        }
        return null;
    }
}
