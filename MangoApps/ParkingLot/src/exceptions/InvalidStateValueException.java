package exceptions;

public class InvalidStateValueException extends RuntimeException {
    public InvalidStateValueException(String message) {
        super(message);
    }
}
