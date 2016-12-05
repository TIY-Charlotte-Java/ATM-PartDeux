package com.theironyard.charlotte;

import java.util.Scanner;

public class Account {
    private String name;
    private String option;
    private String yesOrNo;
    private boolean flag;
    private double balance;
    private static final Scanner scanner = new Scanner(System.in);

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void selectOption () throws Exception {
        {
            flag = true;
            while (flag != false) {
                System.out.println("\nPlease Choose from these following options: ");
                System.out.println("1. Check " + name + "'s Balance");
                System.out.println("2. Withdraw Funds");
                System.out.println("3. Deposit Funds");
                System.out.println("4. Coin Count(Under Construction: Don't select =)");
                System.out.println("5. Cancel");
                option = scanner.next();

                if (option.equals("1")) {
                    System.out.println(name + "'s balance is: " + getBalance());
                    selectReset();
                } else if (option.equals("2")) {
                    System.out.println("How much money would you like to withdraw?");
                    selectWithdraw();
                    selectReset();
                } else if (option.equals("3")) {
                    System.out.println("How much money would you like to deposit?");
                    selectDeposit();
                    selectReset();
                } else if (option.equals("5")) {
                    System.out.println("Thank you for banking at Java National Bank!");
                    flag = false;
                } else if (option.equals("4")) {
                    System.out.println("What did I say? You don't listen. Goodbye!");
                    flag = false;
                }
            }
        }
    }

    public void selectName() throws Exception {
        System.out.println("Please enter your name: ");
        name = scanner.nextLine();
        if (name.isEmpty() || name.startsWith(" ")) {
            throw new Exception("Error: Nothing entered");
        } else {
            System.out.println("Welcome, " + name);
        }
    }

    public void selectWithdraw () throws Exception {
        double withdraw = scanner.nextDouble();
        if ((withdraw <= balance) && (withdraw >= 0)) {
            System.out.println("You have withdrawn: " + withdraw);
            double newBalance = balance - withdraw;
            setBalance(newBalance);
            System.out.println("You have: " + balance + " left in " + name + "'s account");
        } else {
            throw new Exception("Error: Exceeded Balance Amount");
        }
    }

    public void selectDeposit () throws Exception {
        double deposit = scanner.nextDouble();
        if (deposit > 0) {
            balance += deposit;
            setBalance(balance);
            System.out.println("You have deposited: " + deposit);
            System.out.println("Your new balance is: " + getBalance());
        } else {
            throw new Exception("Error: Incorrect input");
        }

    }

    public void selectReset() throws Exception {
        System.out.println("Would you like to revert to the main menu? Yes or No");
        yesOrNo =  scanner.next();
        if (yesOrNo.equalsIgnoreCase("yes")) {
            selectOption();
        } else if (yesOrNo.equalsIgnoreCase("no")) {
            flag = false;
            System.out.println("Thank you for banking at Java National Bank!");
        } else {
            throw new Exception("Error: Incorrect input");
        }
    }

    public static void coinCount (double money) {
        money *= 100;

        int [] currencies = { 100, 25, 10, 5, 1 };

        int dollar = 100;
        int quarter = 25;
        int dime = 10;
        int nickel = 5;
        int penny = 1;

        int dollars = (int)(money / dollar);
        money -= dollars * dollar;

        int quarters = (int)(money / quarter);
        money -= quarters * quarter;

        int dimes = (int)(money / dime);
        money -= dimes * dime;

        int pennies = (int)(money / penny);

        System.out.printf("You have %d dollars, %d quarters, %d dimes, %d nickles and %d pennies. \n", dollars, quarters, dimes, pennies);
    }
}