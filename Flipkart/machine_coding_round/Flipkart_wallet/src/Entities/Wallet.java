package Entities;

public class Wallet {
    Account user;
    Double balance;

    public Wallet(Account user, Double balance) {
        this.user = user;
        this.balance = balance;
    }

    public Account getUser() {
        return user;
    }

    public void setUser(Account user) {
        this.user = user;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
