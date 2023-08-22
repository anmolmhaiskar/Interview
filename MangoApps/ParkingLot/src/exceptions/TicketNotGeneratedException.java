package exceptions;

public class TicketNotGeneratedException extends RuntimeException {
    public TicketNotGeneratedException(String message) {
        super(message);
    }
}
