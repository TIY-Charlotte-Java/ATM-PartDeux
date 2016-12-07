package com.theironyard.charlotte;

import java.util.Scanner;

/**
 * Created by emileenmarianayagam on 12/7/16.
 */
public class Accounts {
    double amountWanted;


    private double balance;

    public Accounts() {

        this.balance = 100;
    }

    public void setBalance(double balance) {

        this.balance = balance;
    }

    public double getBalance() {

        return balance ;
    }


    public void printBalance() {

        System.out.println("your balance is " + getBalance());
    }


    public void amountWithdrawn() throws Exception {
        //Account create = new Account();


        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the amount of fund you would like to withdraw");
        amountWanted = input.nextDouble();
        if (amountWanted > getBalance()) {
            throw new Exception("you want more than what you have... too greedy");
        } else if (amountWanted > 0 && amountWanted <= getBalance()) {
            setBalance(getBalance() - amountWanted);
            System.out.println("Your balance after your withdrawl is " + getBalance());
        } else {
            System.out.println("Thank you and come again");
        }
    }

    public void deposit() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the amount you would like to Deposit");
        //double depositamount;
        amountWanted = input.nextDouble();
        setBalance(getBalance() + amountWanted);
        System.out.println("your balance is after deposit is " + getBalance());
    }


}
