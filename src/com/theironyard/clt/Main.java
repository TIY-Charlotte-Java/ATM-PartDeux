package com.theironyard.clt;

import java.util.Scanner;

/**
 * Created by Ben on 3/30/16.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("What is your name?");

        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        System.out.println("Welccome," + name);

        System.out.println("Choose your option [check balance/withdraw funds]");
        String option = scanner.nextLine();

        if (option.equalsIgnoreCase("check balance")) {
            System.out.println("Your balance is $100!");
        } else if (option.equalsIgnoreCase("withdraw funds")) {
            System.out.println("How much!");
        }

        System.out.println("Choose withdraw value [< 100/> 100");
        String value = scanner.nextLine();

        if (value.equalsIgnoreCase("< 100")) {
            System.out.println("Please take your funds!");
        } else if (value.equalsIgnoreCase("> 100")) {
            System.out.println("Insufficient Funds");
        } else {
            throw new Exception("Invalid value.");
        }

        // This is the starting point of your program
        // Architect your solution however you see fit.

        // quick note: throwing exceptions
        // you can throw a new one with this:
        // throw new IllegalArgumentException("Message About Exception");

        // You will need this in a couple places in your code.
        // We will discuss more about exceptions in the coming days.
    }
}
