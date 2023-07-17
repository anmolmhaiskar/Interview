package Repositories;

import Entities.*;
import Exceptions.AccountAlreadyExist;
import Exceptions.AccountDoesNotExist;
import Exceptions.InvalidWalletBalanceException;
import java.util.HashMap;

public class WalletRepository {
    HashMap<String, Account> accounts;

    public WalletRepository() {
        accounts = new HashMap<>();
    }

    public Account getUser(String user){
        if (!accounts.containsKey(user)){
            System.out.println("Invalid user");
        }
        return accounts.get(user);
    }

    public void createAccount(String username, Double amount, AccountType accountType, String gstNumber){
        System.out.println("createAccount");
        if(accounts.containsKey(username)){
            throw new AccountAlreadyExist("account for " + username + " already exist");
        }
        Account account;
        if (accountType == AccountType.PERSONAL){
            if(amount < 50.0){
                throw new InvalidWalletBalanceException("Personal account's balance should be atleast 50rs");
            }
            account = new PersonalAccount(username, amount);
        }else{
            account = new BusinessAccount(username, amount, gstNumber);
        }
        accounts.put(username, account);
    }

    public boolean isValidUser(String user){
        if (!accounts.containsKey(user)){
            return false;
        }
        return true;
    }
    public Double showBalance(String username) throws AccountDoesNotExist {
        if (!isValidUser(username)){
            throw new AccountDoesNotExist(username + "'s Account does not exit");
        }
        return accounts.get(username).getWallet().getBalance();
    }

    public HashMap<String, Account> overview(){

        return accounts;
    }

    public void transferMoney(String sender, String receiver, Double amount, Double fee) {
        if(!isValidUser(sender) && !isValidUser(receiver)){
            throw new AccountDoesNotExist("Account does not exit");
        }
        Account senderAccount = accounts.get(sender);
        Double newBalance = senderAccount.getWallet().getBalance();
        newBalance = newBalance - amount - fee;
        senderAccount.getWallet().setBalance(newBalance);
//        System.out.println("sender Balance" + senderAccount.getWallet().getBalance());
        accounts.put(sender, senderAccount);


        Account receiverAccount = accounts.get(receiver);
        newBalance = receiverAccount.getWallet().getBalance();
        newBalance = newBalance + amount;
        receiverAccount.getWallet().setBalance(newBalance);
//        System.out.println("sender Balance" + receiverAccount.getWallet().getBalance());
        accounts.put(receiver, receiverAccount);
    }

}
