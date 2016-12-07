package com.theironyard.charlotte;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Ben on 12/6/16.
 */
public class ATM {
    Scanner scanner = new Scanner(System.in);
    private HashMap<String, Account> accounts = new HashMap<>();

    private String selectChoice;
    private Account currentAccount;
    Account a = new Account();

    public Account getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(Account currentAccount) {
        this.currentAccount = currentAccount;
    }

    public Account getAccount(String name) {
        return accounts.get(name);
    }

    public void addAccount(Account acct) {
        accounts.put(acct.getName(), acct);
    }

    public void removeAccount(Account removeAccount) {
        this.currentAccount = removeAccount;
        accounts.remove(removeAccount);
        System.out.println("Account Removed");
    }
    private String getNameFromInput() {
        System.out.println("What is your name?");
        return scanner.nextLine();
    }
    public void selectName() {
        ATM atm = new ATM();

        while (true) {
            String name = getNameFromInput();

            if (name.isEmpty()) {
                continue;
            }

            Account current = atm.getAccount(name);

            if (current == null) {
                System.out.println("Welcome to our Bank! We will start your account with $100.00");

                current = new Account(name);
                atm.addAccount(current);
            }

            atm.setCurrentAccount(current);
            System.out.println("Logged in.");

            displayUserMenu(current);
        }
    }
    private void displayUserMenu(Account account) {
        while (true) {
            Account a = new Account();
            ATM atm = new ATM();
            System.out.println("What would you like to do?");
            System.out.println("1. Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Cancel");
            System.out.println("5. Delete Account");
            System.out.println("6. Exit Program");
            selectChoice = scanner.nextLine();

            if (selectChoice.equals("1")) {
                a.checkBalance();
            } else if (selectChoice.equals("2")) {
                a.withdraw();
            } else {
                if (selectChoice.equals("3")) {
                    a.deposit();
                } else if (selectChoice.equals("4")) {
                    System.out.println("Logging out...");
                    break;
                } else if (selectChoice.equals("5")) {
                    System.out.println("Account Removed");
                    accounts.remove(currentAccount);
                    break;
                } else if (selectChoice.equals("6")) {
                    System.out.println("Have a nice day. Goodbye.");
                    System.exit(0);
                }
            }
        }
    }
    // withdraw, checkbalance, etc.
//public void Menu() {
//    do {
//        System.out.println("What would you like to do?");
//        System.out.println("1. Balance");
//        System.out.println("2. Withdraw");
//        System.out.println("3. Deposit");
//        System.out.println("4. Cancel");
//        System.out.println("5. Delete Account");
//        System.out.println("6. Exit Program");
//        selectChoice = scanner.nextLine();
//
//        if (selectChoice.equals("1")) {
//            a.checkBalance();
//        } else if (selectChoice.equals("2")) {
//            a.withdraw();
//        } else {
//            if (selectChoice.equals("3")) {
//                a.deposit();
//            } else if (selectChoice.equals("4")) {
//                System.out.println("Logging out...");
//                break;
//
//            } else if (selectChoice.equals("5")) {
//                accounts.remove(selectChoice);
//            } else if (selectChoice.equals("6")) {
//                System.out.println("Have a nice day. Goodbye.");
//                System.exit(0);
//            }
//        }
//    } while (selectChoice != "6");
//}
}

