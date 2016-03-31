package com.theironyard.clt;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("Hello, please enter your name.");
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        System.out.println("Welcome, " + name);

        System.out.println("Choose a function, Balance, Withdraw, or Cancel");
        String option = scanner.nextLine();

        if (option.equalsIgnoreCase("balance")) {
            System.out.println("Your balance is $100.");
            String cancel = scanner.nextLine();
            if (cancel.equalsIgnoreCase("cancel")) {
                System.out.println("Thank you, please come again.");
            }

        } else if (option.equalsIgnoreCase("withdraw")) {
            System.out.println("How much?");

            int amount = scanner.nextInt();
            if (amount > 100) {
                System.out.println("Insufficient funds");
                throw new IllegalArgumentException("Amount too great for logical computers.");

            } else if (amount <= 0) {
                System.out.println("Positive amount needed.");
                throw new IllegalArgumentException("Only works in positives.");

            } else {
                System.out.println("Withdraw complete, please take your money.");
                

            }
        }





        // quick note: throwing exceptions
        // you can throw a new one with this:
        // throw new IllegalArgumentException("Message About Exception");

        // You will need this in a couple places in your code.
        // We will discuss more about exceptions in the coming days.
    }
}
