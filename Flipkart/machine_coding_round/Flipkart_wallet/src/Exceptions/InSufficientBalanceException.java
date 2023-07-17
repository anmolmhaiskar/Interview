package Exceptions;

public class InSufficientBalanceException extends RuntimeException {
    public InSufficientBalanceException(String str){
        super(str);
    }
}
