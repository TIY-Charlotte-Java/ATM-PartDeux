package com.theironyard.clt;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name.");
        String name = scanner.nextLine();
        System.out.println("Hello " + name + ", please select an option.");



        displayMenu();

        // quick note: throwing exceptions
        // you can throw a new one with this:
        // throw new IllegalArgumentException("Message About Exception");

        // You will need this in a couple places in your code.
        // We will discuss more about exceptions in the coming days.
    }

    private static int choose(ArrayList<Integer> options) {
        Scanner decision = new Scanner(System.in);
        int choice = -1;
        try {
            choice = decision.nextInt();
        }
        catch(InputMismatchException wrong) {
        }
        if (!options.contains(choice)) {
            choice = -1;
            System.out.println("Come on man!");
        }
        return choice;

    }
    public static void displayMenu() {
        int selection = 0;
        ArrayList<Integer> options = new ArrayList<>();

        options.add(1);
        options.add(2);
        options.add(3);
        do {
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Funds");
            System.out.println("3. Deposit Funds");

            selection = choose(options);

        } while(selection == -1);
        if (selection == 1) {
            System.out.println("balance checked!");
        }
        else if (selection == 2) {
            System.out.println("Take your money.");
        }
        else if (selection == 3) {
            System.out.println("Money deposited.");
        }
    }
}
