package com.theironyard.charlotte;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by kelseynewman on 12/1/16.
 */
public class ATM {
    private double balance = 100;

    private static final Scanner scanner = new Scanner(System.in);

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void selectTask() throws Exception {
        System.out.println("What would you like to do? Select 1 - check balance, 2 - make a withdrawal or 3 - cancel");
        String task = scanner.nextLine();

        if (task.equals("1")) {
            System.out.println(getBalance());
        } else if (task.equals("2")) {
            makeWithdrawal();
        } else if (task.equals("3")) {
            System.out.println("Thank you. Please come again.");
            exitProgram();
        } else {
            throw new Exception ("Invalid selection. Please try again.");
        }
    }

    public double makeWithdrawal() throws Exception {
        System.out.println("How much would you like to withdraw?");
        Double withdrawal = scanner.nextDouble();

        if (withdrawal > 0 && withdrawal <= 100) {
            System.out.println("Please take your money.");
            setBalance(balance - withdrawal);
            System.out.println("Remaining balance is $" + getBalance());
            return balance;
        } else {
            throw new Exception("Insufficient funds. Please try again.");
        }
    }

    public void exitProgram() {
        System.exit(0);
    }

    HashMap <String, Double> person = new HashMap<>();

//    static void changeReturned ( double balance ) {
//        double twenties = balance/20;
//        int numberOfTwenties = (int)twenties;
//        System.out.println("The number of twenties dispensed is " + numberOfTwenties);
//        double remainder = balance % 20;
//
//        double tens = remainder/10;
//        int numberOfTens = (int)tens;
//        System.out.println("The number of tens dispensed is " + numberOfTens);
//        double remainder2 = remainder % 10;
//
//        double fives = remainder2/5;
//        int numberOfFives = (int)fives;
//        System.out.println("The number of fives dispensed is " + numberOfFives);
//        double remainder3 = remainder2 % 5;
//
//        double ones = remainder3/1;
//        int numberOfOnes = (int)ones;
//        System.out.println("The number of ones dispensed is " + numberOfOnes);
//        double remainder4 = remainder3%1;
//
//        double quarters = remainder4/.25;
//        int numberOfQuarters = (int)quarters;
//        System.out.println("The number of quarters dispensed is " + numberOfQuarters);
//        double remainder5 = remainder4%.25;
//
//        double dimes = remainder5/.10;
//        int numberOfDimes = (int)dimes;
//        System.out.println("The number of dimes dispensed is " + numberOfDimes);
//        double remainder6 = remainder5%.10;
//
//        double nickels = remainder6/.05;
//        int numberOfNickels = (int)nickels;
//        System.out.println("The number of nickels dispensed is " + numberOfNickels);
//        double remainder7 = remainder6%.05;
//
//        double pennies = remainder7/.01;
//        int numberOfPennies = (int)pennies;
//        System.out.println("The number of pennies dispensed is " + numberOfPennies);
//    }

}
