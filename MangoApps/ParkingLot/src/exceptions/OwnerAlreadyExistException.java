package exceptions;

public class OwnerAlreadyExistException extends RuntimeException {
    public OwnerAlreadyExistException(String message) {
        super(message);
    }
}
