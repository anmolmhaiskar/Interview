package Entities;

public enum AccountType {
    PERSONAL,
    BUSINESS;

    public String toString(){
        switch(this){
            case PERSONAL:
                return "PERSONAL";
            case BUSINESS :
                return "BUSINESS";
        }
        return null;
    }
}
