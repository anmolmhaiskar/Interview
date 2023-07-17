package Exceptions;

public class AccountDoesNotExist extends RuntimeException {
    public AccountDoesNotExist(String str){
        super(str);
    }
}
