package com.theironyard.charlotte;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    private static String getName() {
        System.out.println ("Hello! What is your name?");
        return scanner.nextLine();
    }

    private static void userMenu(Account account) throws Exception {
        while (true) {
            System.out.println("What would you like to do now?");
            System.out.println("Select an option:");
            System.out.println("1 - check balance");
            System.out.println("2 - make a withdrawal");
            System.out.println("3 - make a deposit");
            System.out.println("4 - remove account");
            System.out.println("5 - cancel");
            String nextTask = scanner.nextLine();

            if (nextTask.equals("1")) {
                System.out.println("Your balance is " + account.balance);
            } else if (nextTask.equals("2")) {
                account.makeWithdrawal();
            } else if (nextTask.equals("3")) {
               account.makeDeposit();
            } else if (nextTask.equals("4")) {
                account.removeAccount();
            } else if (nextTask.equals("5")) {
                System.out.println("Thank you. Please come again.");
                account.cancel();
                break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ATM atm = new ATM();
        Account account = new Account();

    while (true) {
        String name = getName();

        if (name.isEmpty()) {
            continue;
        }

        Account current = atm.getAccount(name);

        if (current == null) {
            System.out.println("I'm sorry, it doesn't look like you have an account with us.");
            System.out.println("Would you like to create one?");
            String create = scanner.nextLine();
            if (create.equalsIgnoreCase("yes")) {
                System.out.println("Welcome to Silverman Bags! We will start your account with $100.");

                current = new Account(name);
                atm.addAccount(current);
            } else
                account.cancel();
        }

        atm.setCurrentAccount(current);
        System.out.println("You are now logged in.");

        userMenu(current);
        }
    }
}