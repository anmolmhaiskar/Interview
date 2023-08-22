package services;

import enums.ModeOfPayment;
import enums.PaymentStatus;
import exceptions.PaymentFailedException;
import models.Payment;
import models.Ticket;
import repositories.PaymentRepository;
import utils.PaymentFactory;

public class PaymentService {

    public static PaymentRepository paymentRepository = PaymentFactory.getInstance();

    public static Payment makePayment(Ticket ticket, ModeOfPayment mode) {
        validatePayment(ticket, mode);
        Payment payment = paymentRepository.makePayment(ticket, mode, PaymentStatus.INPROGRESS, ticket.getAmount(), ticket.getVehicle().getOwner());
        if(payment != null){
            paymentRepository.updatePaymentStatus(payment, PaymentStatus.COMPLETED);
        }
        else throw new PaymentFailedException(String.format("The payment with id %s for the ticket no %s has failed", payment.getId(), ticket.getTicketNo()));
        return payment;
    }

    public static void validatePayment(Ticket ticket, ModeOfPayment mode){
        if(ticket == null || mode == null){
            throw new PaymentFailedException("Payment Failed. Value of ticket or mode of payment is null");
        }
    }
}
