package exceptions;

public class VehicleIsNotPresentException extends RuntimeException{
    public VehicleIsNotPresentException(String message) {
        super(message);
    }
}
