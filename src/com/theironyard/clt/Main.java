package com.theironyard.clt;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Ben on 3/30/16.
 */
public class Main {

    public static void main(String[] args) {
        displayMenu();
    }

    private static int makeSelection(ArrayList<Integer> options) {
        Scanner input = new Scanner(System.in);

        int choice = -1;

        try {
            choice = input.nextInt();
        }

        catch (InputMismatchException ex) {

        }

        if (options.contains(choice) == false {
            choice = -1;
            System.out.println("Invalid Selection.");
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
             System.out.println("3. Deposi Money");

             selection = makeSelection(options);
         } while (selection == -1);

         if (selection == 1) {
             //checkBalance ();
             System.out.println("Checked Balance");

         } else if (selection == 2) {
             //withdraw
             System.out.println("Withdrew Money");
         }






    }
}
