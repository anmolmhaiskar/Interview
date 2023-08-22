package exceptions;

public class EntranceNotFoundException extends RuntimeException {
    public EntranceNotFoundException(String message) {
        super(message);
    }
}
