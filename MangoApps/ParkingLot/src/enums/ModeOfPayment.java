package enums;

public enum ModeOfPayment {
    UPI,
    CASH,
    CREDIT_CARD,
    DEBIT_CARD;

    public String toString(){
        return switch (this) {
            case UPI -> "UPI";
            case CASH -> "CASH";
            case CREDIT_CARD -> "CREDIT_CARD";
            case DEBIT_CARD -> "DEBIT_CARD";
            default -> null;
        };
    }
}
