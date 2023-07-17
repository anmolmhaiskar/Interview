package Entities;

public class BusinessAccount extends Account{
    String gstNumber;
    public BusinessAccount(String name, Double balance) {
        super(name, balance);
    }

    public BusinessAccount(String name, Double balance, String gstNumber) {
        super(name, balance);
        this.gstNumber = gstNumber;
    }

    public String getGstNumber() {
        return gstNumber;
    }

    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }
}
