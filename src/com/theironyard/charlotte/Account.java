package com.theironyard.charlotte;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by graceconnelly on 12/1/16.
 */
public class Account {

    //Variables
    private String inputName;
    private String targetAccount;
    private double balanceChangeRequest;
    private int selection;
    private HashMap<String, Double> accounts = new HashMap<>();

    //Call up scanner
    private final Scanner scanner = new Scanner(System.in);

    //Getters and Setters
    public Scanner getScanner() { return scanner; }

    public String getInputName() { return inputName; }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public String getTargetAccount() { return targetAccount; }

    public void setTargetAccount(String targetAccount) { this.targetAccount = targetAccount; }

    public double getBalanceChangeRequest() { return balanceChangeRequest; }

    public void setBalanceChangeRequest(double balanceChangeRequest) { this.balanceChangeRequest = balanceChangeRequest; }

    public int getSelection() {
        return selection;
    }

    public void setSelection(int selection) {
        this.selection = selection;
    }

    public HashMap<String, Double> getAccounts() {
        return accounts;
    }

    //Start Methods
    public void initialNameRequest() throws Exception {
        System.out.println("Greetings, bank member!");
        System.out.println("What is your name?");
        setInputName(scanner.nextLine());
    }
    public void createAccount(){//throws Exception{
        System.out.println(getInputName() + ", I am unable to locate an account for you.");
        System.out.println("Would you like to create a new one? [Y/N]");
        if (scanner.nextLine().equalsIgnoreCase("Y")){
            getAccounts().put(getInputName(),100.0);
            System.out.println("A new account with the name " + getInputName() + " was created.");
        }
        else{
            setInputName("");
            System.out.println("Cancelling");
        }
    }
    public void chooseEvent() {
        System.out.println("Please, select the number for what you would like to do.\n" +
                "1) Check Balance\n" +
                "2) Deposit Funds\n" +
                "3) Withdraw Funds\n" +
                "4) Remove Account\n" +
                "5) Transfer Funds\n" +
                "6) Cancel");
        setSelection(Integer.valueOf(scanner.nextLine()));
    }
    public void depositFunds() {
        System.out.println("How much money would you like to deposit?");
        setBalanceChangeRequest(Math.round(Double.valueOf(scanner.nextLine()) *(double)100));
        setBalanceChangeRequest(getBalanceChangeRequest() /(double)100);
        System.out.println("Processing request to deposit: $" + getBalanceChangeRequest());

        if (getBalanceChangeRequest() < 0) {
            System.out.println("You cannot deposit negative money");
            setSelection(6);
            //throw new Exception("You cannot withdraw negative money");
        } else {
            getAccounts().put(getInputName(),getAccounts().get(getInputName()) + getBalanceChangeRequest());
            System.out.println("WOW! Your new balance is $" + getAccounts().get(getInputName()));
        }
    }
    public void withdrawFunds() { //throws Exception {
        System.out.println("How much would you like to withdraw?");
        //Get and round
        setBalanceChangeRequest(Math.round(Double.valueOf(scanner.nextLine()) *(double)100));
        setBalanceChangeRequest(getBalanceChangeRequest() /(double)100);
        System.out.println("Processing request to withdraw: $" + getBalanceChangeRequest());

        if (getBalanceChangeRequest() > getAccounts().get(getInputName())) {
            System.out.println("YOU AIN'T GOT THAT MUCH MULAH! a.k.a. There isn't that much cheddar in your cheese shop.");
            setSelection(6);
            //throw new Exception("YOU AIN'T GOT THAT MUCH MULAH! a.k.a. There isn't that much cheddar in your cheese shop.");
        } else if (getBalanceChangeRequest() < 0) {
            System.out.println("You cannot withdraw negative money");
            setSelection(6);
            //throw new Exception("You cannot withdraw negative money");
        } else {
            getAccounts().put(getInputName(),getAccounts().get(getInputName()) - getBalanceChangeRequest());
            Transaction.correctCoinage(getBalanceChangeRequest());
            System.out.println("Please remove your Cash Money!");
            System.out.println("WOW! Your remaining balance is $" + getAccounts().get(getInputName()));
        }
    }
    public void removeAccount(){//throws Exception{
        System.out.println(getInputName() + " do you really want to delete your account? [Y/N]");
        if (scanner.nextLine().equalsIgnoreCase("Y")){
            getAccounts().remove(getInputName());
            System.out.println("The account for " + getInputName() + " was removed.");
        }
    }
    public void transferMoney(){
        System.out.println(getInputName()+" Who would you like to transfer money to?");
        setTargetAccount(scanner.nextLine());
        if(getAccounts().get(getTargetAccount()) == null){
            System.out.printf("Sorry %s , I have no record of an account with %s. \n" +
                    "You could cancel and create an account for %s\n",getInputName(),getTargetAccount(), getTargetAccount());
        }
        System.out.printf("%s, your current balance is $%G.\n" +
                "How much would you like to transfer to %s?\n",getInputName(),getAccounts().get(getInputName()),getTargetAccount());
        //transfers users input amount to target account.
        setBalanceChangeRequest(Double.valueOf(scanner.nextLine()));
        // could probably use a static for this balance change to make it prettier. not sure how yet
        getAccounts().put(getInputName(),getAccounts().get(getInputName()) - getBalanceChangeRequest());
        getAccounts().put(getTargetAccount(),getAccounts().get(getTargetAccount()) + getBalanceChangeRequest());
        //print resulting balances
        System.out.printf("%s, your remaining balance is $%G.\n",getInputName(),getTargetAccount(),getAccounts().get(getInputName()));
        //System.out.printf("%s, the target Account %s has a balance of $%G\n",getInputName(),getTargetAccount(),getAccounts().get(getTargetAccount()));
    }
}