package com.theironyard.charlotte;

import java.util.HashMap;
import java.util.Scanner;

public class Account {
    private String name;
    private String option;
    private String yesOrNo;
    private String createAcct;
    private boolean flag;
    private double balance;
    private static final Scanner scanner = new Scanner(System.in);

    HashMap<String, Double> accounts = new HashMap<>();

    //Setters and Getters

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getOption() {
        return option;
    }
    public void setOption(String option) {
        this.option = option;
    }

    public String getYesOrNo() {
        return yesOrNo;
    }
    public void setYesOrNo(String yesOrNo) {
        this.yesOrNo = yesOrNo;
    }

    public String getCreateAcct() {
        return createAcct;
    }
    public void setCreateAcct(String createAcct) {
        this.createAcct = createAcct;
    }

    public boolean isFlag() {
        return flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    //Methods

    public void selectOption () throws Exception {
        {
            setFlag(true);
            while (isFlag()) {
                System.out.println("\nPlease Choose from these following options: ");
                System.out.println("1. Check " + getName() + "'s Balance");
                System.out.println("2. Withdraw Funds");
                System.out.println("3. Deposit Funds");
                System.out.println("4. Coin Count");
                System.out.println("5. Delete Account");
                System.out.println("6. Main Menu");
                System.out.println("7. Exit ATM");
                setOption(scanner.next());

                if (getOption().equals("1")) {
                    System.out.println(name + "'s balance is: " + getBalance());
                    selectReset();
                } else if (getOption().equals("2")) {
                    System.out.println("How much money would you like to withdraw?");
                    selectWithdraw();
                    selectReset();
                } else if (getOption().equals("3")) {
                    System.out.println("How much money would you like to deposit?");
                    selectDeposit();
                    selectReset();
                } else if (getOption().equals("7")) {
                    System.out.println("Thank you for banking at Java National Bank!");
                    setFlag(false);
                } else if (getOption().equals("4")) {
                    coinCount(getBalance());
                    selectReset();
                    setFlag(false);
                } else if (getOption().equals("5")) {
                    deleteAccount();
                    createAccount();
                } else if (getOption().equals("6")) {
                    createAccount();
                }
            }
        }
    }

    public void selectName() throws Exception {
        System.out.println("Please enter your name: ");
        setName(scanner.next());
        if (getName().isEmpty() || getName().startsWith(" ")) {
            throw new Exception("Error: Nothing entered");
        } else if (accounts.containsKey(getName())){
            System.out.println("Welcome, " + getName());
        } else {
            throw new Exception("Error: Not an account");
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
            setBalance(deposit + balance);
            //setBalance(balance);
            System.out.println("You have deposited: " + deposit);
            System.out.println("Your new balance is: " + getBalance());
        } else {
            throw new Exception("Error: Incorrect input");
        }

    }

    public void selectReset() throws Exception {
        System.out.println("\nWould you like to revert to the main menu? Yes or No");
        setYesOrNo(scanner.next());
        if (getYesOrNo().equalsIgnoreCase("yes")) {
            selectOption();
        } else if (getYesOrNo().equalsIgnoreCase("no")) {
            setFlag(false);
            System.out.println("Thank you for banking at Java National Bank!");
        } else {
            throw new Exception("Error: Incorrect input");
        }
    }

    public static void coinCount (double money) {
        money *= 100;

       // int [] currencies = { 100, 25, 10, 5, 1 };

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

        int nickels = (int)(money/ nickel);
        money -= nickels * nickel;

        int pennies = (int)(money / penny);

        System.out.printf("You have %d dollars, %d quarters, %d dimes, %d nickles and %d pennies. \n",dollars,quarters,dimes,nickels,pennies);
    }

    public void createAccount() throws Exception {
        System.out.println("Do you have an account with Java National Bank?");
        setCreateAcct(scanner.next());
        if (getCreateAcct().equalsIgnoreCase("yes")) {
            selectName();
            setBalance(accounts.get(name));
            selectOption();
        } else if (getCreateAcct().equalsIgnoreCase("no")) {
            System.out.println("Let's create an account!");
            System.out.println("Please enter your name and the deposit value: ");
            setName(scanner.next());
            setBalance(scanner.nextDouble());
            accounts.put(name, balance);
        } else {
            throw new Exception("Error: Incorrect choice");
        }
    }

    public void deleteAccount() throws Exception {
        accounts.remove(getName());
        System.out.println("You have successfully removed your account!");
        //createAccount();
    }
}