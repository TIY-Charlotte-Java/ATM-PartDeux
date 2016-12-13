package com.theironyard.charlotte;

/**
 * Created by Ben on 12/13/16.
 */
public class Account {
    private double balance;
    private String ownerName;


    public Account(String ownerName) {
        this.ownerName = ownerName;
        this.balance = 100.00;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
