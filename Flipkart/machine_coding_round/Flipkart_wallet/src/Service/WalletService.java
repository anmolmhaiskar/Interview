package Service;

import Entities.Account;
import Entities.AccountType;
import Entities.BusinessAccount;
import Exceptions.AccountAlreadyExist;
import Exceptions.AccountDoesNotExist;
import Exceptions.InSufficientBalanceException;
import Exceptions.InvalidAccountTypeTransactionException;
import Repositories.WalletRepository;

import java.util.HashMap;
import java.util.List;

public class WalletService {

    public Double revenueGenerated;
    WalletRepository walletRepository;
    public WalletService(){
        revenueGenerated = 0.0;
        walletRepository = new WalletRepository();
    }
    public void createWallet(String username, Double amount, AccountType accountType, String gstNumber) throws AccountAlreadyExist {
        walletRepository.createAccount(username, amount, accountType, gstNumber);

    }

    public void transferMoney(String moneySender, String moneyReceiver, Double amount, Double fee) {
        if(validateTransaction(moneySender, moneyReceiver, amount)){
            revenueGenerated += fee;
            walletRepository.transferMoney(moneySender, moneyReceiver, amount, fee);
        }
    }

    public void showBalance(String user) throws AccountDoesNotExist {
        print(walletRepository.showBalance(user).toString());
    }


    public void overview() {
        System.out.println("overview");
        HashMap<String, Account> accounts = walletRepository.overview();
        for(String user : accounts.keySet()){
            print(user + " " + accounts.get(user).getWallet().getBalance().toString());
        }
    }

    public boolean hasSufficientBalance(String user, Double amount, Double minBalance) {
//        System.out.println("hasSufficientBalance" + (walletRepository.getUser(user).getWallet().getBalance()-minBalance) + " " + amount );
        if(amount < walletRepository.getUser(user).getWallet().getBalance()-minBalance){
            return true;
        }
        return false;
    }

    public boolean validateTransaction(String moneySender, String moneyReceiver, Double amount){
        if(!walletRepository.isValidUser(moneyReceiver) && !walletRepository.isValidUser(moneyReceiver)){
            throw new AccountDoesNotExist(moneySender + " Account does not exit");
        }
        if(walletRepository.getUser(moneySender) instanceof BusinessAccount){
            if(walletRepository.getUser(moneyReceiver) instanceof BusinessAccount){
                if(hasSufficientBalance(moneySender, amount, 0.0)){
                    return true;
                }
                else throw new InSufficientBalanceException("Insufficient balance found in the sender's account");
            }
            else throw new InvalidAccountTypeTransactionException("Transaction between business and personal account is not allowed");
        }
        else if(hasSufficientBalance(moneySender, amount, 50.0)){
            return true;
        }
        else throw new InSufficientBalanceException("Insufficient balance found in the sender's account");
    }

    public void print(String str){
        System.out.println(str);
    }
}
