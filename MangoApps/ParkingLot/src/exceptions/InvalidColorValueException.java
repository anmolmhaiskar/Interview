package exceptions;

public class InvalidColorValueException extends RuntimeException {
    public InvalidColorValueException(String message) {
        super(message);
    }
}
