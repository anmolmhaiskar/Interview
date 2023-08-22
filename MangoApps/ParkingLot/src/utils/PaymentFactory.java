package utils;

import repositories.PaymentRepository;

public class PaymentFactory {
    private static PaymentRepository paymentInstance;
    private PaymentFactory(){

    }
    public static PaymentRepository getInstance() {
        if (paymentInstance == null) {
            synchronized (PaymentRepository.class) {
                if (paymentInstance == null) {
                    paymentInstance = new PaymentRepository();
                }
            }
        }
        return paymentInstance;
    }
}
