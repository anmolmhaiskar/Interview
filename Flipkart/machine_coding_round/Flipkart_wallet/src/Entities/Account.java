package Entities;

public abstract class Account {
    String name;
    Wallet wallet;

    public Account(String name, Double balance) {
        this.name = name;
        this.wallet = new Wallet(this, balance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
}
