package com.theironyard.charlotte;

import java.util.Scanner;

/**
 * Created by Ben on 12/6/16.
 */
public class Account {
    private String name;
    private double balance;
    Scanner scanner = new Scanner(System.in);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    Account() {
        balance = 100;
    }

    Account(String name) {
        this.balance = 100;
        this.name = name;
    }

    public void withdraw() {
        System.out.println("Enter desired withdraw amount 1: $20, 2: $40, 3: $60, 4: $80, 5: $100");

        String withdraw = scanner.nextLine();
        if (withdraw.equals ("1") && balance >= 20) {
            System.out.println("Withdrawing $20...");
            balance = balance - 20;
            System.out.println("Withdraw Successful. Balance remaining " + balance);
        }
        else if (withdraw.equals("2") && balance >= 40) {
            System.out.println("Withdrawing $40...");
            balance = balance - 40;
            System.out.println("Withdraw Successful. Balance remaining " + balance);
        }
        else {
            if (withdraw.equals("3") && balance >= 60) {
                System.out.println("Withdrawing $60...");
                balance = balance - 60;
                System.out.println("Withdraw Successful. Balance remaining " + balance);
            }
            else if (withdraw.equals("4") && balance >= 80) {
                System.out.println("Withdrawing $80...");
                balance = balance - 80;
                System.out.println("Withdraw Successful. Balance remianing " + balance);

            }
            else {
                if (withdraw.equals("5") && balance >= 100) {
                    System.out.println("Withdrawing $100...");
                    balance = balance - 100;
                    System.out.println("Withdraw Successful. Balance remianing " + balance);
                }
                else {
                    System.out.println("Insufficient Funds. Please select another amount.");
                }
            }
        }
    }

    public void deposit() {
        System.out.println("Select desired deposit amount.");
        System.out.println("1. $20");
        System.out.println("2. $40");
        System.out.println("3. $60");
        System.out.println("4. $80");
        System.out.println("5. $100");

        String deposit = scanner.nextLine();
        if (deposit.equals ("1")) {
            System.out.println("Depositing $20...");
            balance = balance + 20;
            System.out.println("Deposit Successful. Balance remaining " + balance);
        }
        else if (deposit.equals("2")) {
            System.out.println("Depositing $40...");
            balance = balance + 40;
            System.out.println("Deposit Successful. Balance remaining " + balance);
        }
        else {
            if (deposit.equals("3")) {
                System.out.println("Depositing $60...");
                balance = balance + 60;
                System.out.println("Deposit Successful. Balance remaining " + balance);
            } else if (deposit.equals("4")) {
                System.out.println("Depositing $80...");
                balance = balance + 80;
                System.out.println("Deposit Successful. Balance remaining " + balance);

            } else {
                if (deposit.equals("5")) {
                    System.out.println("Depositing $100...");
                    balance = balance + 100;
                    System.out.println("Deposit Successful. Balance remaining " + balance);
                } else {
                    System.out.println("Invalid deposit. Please try again.");
                }
            }
        }
    }

    public void checkBalance() {
        System.out.println("Your current balance is " + balance);
        balance = balance;
    }

    public void deleteAccount() {
    }
}
