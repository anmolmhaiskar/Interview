package enums;

public enum PaymentStatus {
    COMPLETED,
    PENDING,
    FAILED;

    public String toString(){
        return switch (this) {
            case COMPLETED -> "COMPLETED";
            case PENDING -> "PENDING";
            case FAILED -> "FAILED";
            default -> null;
        };
    }
}
