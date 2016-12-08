package com.theironyard.charlotte;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static String selectChoice;
    static Account a = new Account();
    static ATM at = new ATM();
    public static void main(String[] args) {
        at.selectName();
    }
//    private static String getNameFromInput() {
//        System.out.println("What is your name?");
//        return scanner.nextLine();
//    }
//
//    private static void displayUserMenu(Account account) {
//        while (true) {
//            System.out.println("What would you like to do?");
//            System.out.println("1. Balance");
//            System.out.println("2. Withdraw");
//            System.out.println("3. Deposit");
//            System.out.println("4. Cancel");
//            System.out.println("5. Delete Account");
//            System.out.println("6. Exit Program");
//            selectChoice = scanner.nextLine();
//
//            if (selectChoice.equals("1")) {
//                a.checkBalance();
//            } else if (selectChoice.equals("2")) {
//                a.withdraw();
//            } else {
//                if (selectChoice.equals("3")) {
//                    a.deposit();
//                } else if (selectChoice.equals("4")) {
//                    System.out.println("Logging out...");
//                    break;
//                } else if (selectChoice.equals("5")) {
//                    atm.removeAccount(account);
//                    break;
//                } else if (selectChoice.equals("6")) {
//                    System.out.println("Have a nice day. Goodbye.");
//                    System.exit(0);
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        ATM atm = new ATM();
//
//        // ask for a person's name forever.
//        while (true) {
//            String name = getNameFromInput();
//
//            if (name.isEmpty()) {
//                continue;
//            }
//
//            Account current = atm.getAccount(name);
//
//            if (current == null) {
//                System.out.println("Welcome to our Bank! We will start your account with $100.00");
//
//                current = new Account(name);
//                atm.addAccount(current);
//            }
//
//            atm.setCurrentAccount(current);
//            System.out.println("Logged in.");
//
//            displayUserMenu(current);
//        }
//        // look up that person's account details and
//        // present them with their account options
//        // allow them to select options forever
//        // when they're done, loop.
//    }

}
