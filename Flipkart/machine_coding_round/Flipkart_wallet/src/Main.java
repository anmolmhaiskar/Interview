import Entities.AccountType;
import Exceptions.AccountAlreadyExist;
import Exceptions.AccountDoesNotExist;
import Service.WalletService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws AccountAlreadyExist, AccountDoesNotExist {
        try {
            WalletService walletService=new WalletService();
            while (true) {
                Scanner scanner = new Scanner(System.in);
                String command = scanner.nextLine();
                String[] commands = command.split(" ");
                try {
                switch (commands[0]) {
                        case "CreateWallet":
                            System.out.println("createwallet " + AccountType.PERSONAL.toString() + " " + commands[1].toUpperCase());
                            commands[1] = commands[1].toUpperCase();
                            if (commands[1].equals(AccountType.PERSONAL.toString())) {
                                walletService.createWallet(commands[2], Double.parseDouble(commands[3]), AccountType.valueOf(commands[1]), null);
                            } else {
                                walletService.createWallet(commands[2], Double.parseDouble(commands[4]), AccountType.valueOf(commands[1]), commands[3]);
                            }

                            break;

                        case "Overview":
                            walletService.overview();
                            break;

                        case "TransferMoney":
                            Double fee = 0.0;
                            walletService.transferMoney(commands[1], commands[2], Double.parseDouble(commands[3]), fee);
                            break;

                        case "Balance":
                            walletService.showBalance(commands[1]);
                            break;
                    }
                }catch(Exception e){
                    System.out.println(e.getMessage());e.printStackTrace();
                }
            }
        }catch (Exception e){
            System.out.println("Main method exception");
            e.printStackTrace();
        }
    }
}