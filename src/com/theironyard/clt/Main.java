
package com.theironyard.clt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Ben on 3/30/16.
 */
public class Main {

    //main method

    public  static void main(String[] args) {
        displayMenu();

    }

    // display menu method

    private static void displayMenu() {
        int selection = 0;

        ArrayList<Integer> options = new ArrayList<>();

        options.add(1);
        options.add(2);
        options.add(3);

        do {
            System.out.println("\n\n       Bank Account Menu");
            System.out.println("##############################");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Funds");
            System.out.println("3. Deposit Money");
            System.out.println("\nSelect a Menu Option: ");

            selection = makeSelection(options);
        } while (selection == -1);

        if (selection == 1) {
            // checkBalance();
            System.out.println("Checked Balance");
        } else if (selection == 2) {
            // withdraw
            System.out.println("Withdrew Money");
        } else if (true) {
            // deposit
            System.out.println("Deposited Cash");

        }
        while (true); // Display the menu until the user closes the program

    }

    //input method

        private static int makeSelection(ArrayList<Integer> options) {
            Scanner input = new Scanner(System.in);

            int choice = -1;

            try {
                choice = input.nextInt();
            }

            catch (InputMismatchException ex) {
            }

            if (options.contains(choice) == false) {
                choice = -1;
                System.out.println("Invalid Selection.");
            }

            return choice;
    }


}
