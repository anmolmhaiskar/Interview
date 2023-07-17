package Exceptions;

public class InvalidWalletBalanceException extends RuntimeException {
    public InvalidWalletBalanceException(String str) {
        super(str);
    }
}
