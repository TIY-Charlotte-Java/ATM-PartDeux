package com.theironyard.charlotte;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Ben on 12/13/16.
 */
public class ATM {
    private static Scanner consoleScanner = new Scanner(System.in);

    private Account currentAccount;
    public HashMap<String, Account> accounts = new HashMap<>();

    public Account getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(Account currentAccount) {
        this.currentAccount = currentAccount;
    }

    public static String selectName() {
        System.out.println("Please enter your name:");
        return consoleScanner.nextLine();
    }

    // loop while person makes an invalid selection
    public static int makeSelection () {
        int selection = 0;

        do {
            try {
                selection = selectMenuOption();
            } catch (Exception ex) {
                continue;
            }
        }
        while (selection == 0);

        return selection;
    }

    private static int selectMenuOption() throws Exception {
        System.out.println("Select From the Following Options:");
        System.out.println("1: Check Your Balance");
        System.out.println("2: Deposit Funds");
        System.out.println("3: Withdraw Funds");
        System.out.println("4: Remove Account");
        System.out.println("5: Sign Out");

        int selection = Integer.valueOf(consoleScanner.nextLine());

        if (selection < 1 || selection > 5) {
            throw new Exception ("Invalid Selection");
        }

        return selection;
    }

    public static void printBalance(Account account) {
        System.out.printf("Your current balance is: $%.2f\n", account.getBalance());
    }

    public static void depositFunds(Account account) {
        System.out.println("How much would you like to add to your account?");

        double amount = Double.valueOf(consoleScanner.nextLine());

        if (amount > 0) {
            account.deposit(amount);

            System.out.printf("Thank you for your deposit. Your new balance is %.2f\n", account.getBalance());
        } else {
            System.out.println("That is an invalid amount to deposit. If you would like to make a withdraw, select the appropriate menu option.");
        }
    }

    public static void withdrawFunds(Account account) {
        System.out.println("How much money would you like to remove?");

        double amount = Double.valueOf(consoleScanner.nextLine());

        if (amount < 0) {
            System.out.println("Withdraw can't be less than 0. That is a deposit. Please select \"deposit\".");
        } else if (amount > account.getBalance()) {
            System.out.println("You don't have that much money.");
        } else {
            account.withdraw(amount);
        }
    }

    public static void removeAccount(ATM atm) {
        atm.accounts.remove(atm.getCurrentAccount().getOwnerName());
        signOut(atm);

        System.out.println("USER BALEETED");
    }

    public static void signOut(ATM atm) {
        atm.setCurrentAccount(null);

        System.out.println("GOODBYE SIR OR MADAME");
    }
}
