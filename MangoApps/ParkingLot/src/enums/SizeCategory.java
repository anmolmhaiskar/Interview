package enums;

public enum SizeCategory {
    SMALL,
    MEDIUM,
    LARGE,
    HUGE;

    public String toString(){
        return switch (this) {
            case SMALL -> "SMALL";
            case MEDIUM -> "MEDIUM";
            case LARGE -> "LARGE";
            case HUGE -> "HUGE";
            default -> null;
        };
    }
}
