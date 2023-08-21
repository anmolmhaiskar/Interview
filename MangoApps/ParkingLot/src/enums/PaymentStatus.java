package enums;

public enum PaymentStatus {
    COMPLETED,
    PENDING,
    INPROGRESS,
    FAILED;

    public String toString(){
        return switch (this) {
            case COMPLETED -> "COMPLETED";
            case PENDING -> "PENDING";
            case INPROGRESS -> "INPROGRESS";
            case FAILED -> "FAILED";
            default -> null;
        };
    }
}
