package exceptions;

public class SpotNotAvailableException extends RuntimeException{
    public SpotNotAvailableException(String message){
        super(message);
    }
}
