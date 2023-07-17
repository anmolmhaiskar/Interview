package Exceptions;

public class AccountAlreadyExist extends RuntimeException{

    public AccountAlreadyExist(String str) {
        super(str);
    }
}
