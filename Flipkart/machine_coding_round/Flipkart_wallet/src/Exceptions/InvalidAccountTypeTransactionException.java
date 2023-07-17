package Exceptions;

public class InvalidAccountTypeTransactionException extends RuntimeException {
    public InvalidAccountTypeTransactionException(String str){
        super(str);
    }
}
