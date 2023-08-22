package exceptions;

public class InvalidOwnerDetailsException extends RuntimeException {
    public InvalidOwnerDetailsException(String message) {
        super(message);
    }
}
