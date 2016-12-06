package com.theironyard.charlotte;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by graceconnelly on 12/1/16.
 */
public class Account {

    //variables
    private String inputName;
    private HashMap<String, Double> accounts = new HashMap<>();

    //Call up scanner
    private static final Scanner scanner = new Scanner(System.in);

    //Getters and Setters
    public String getInputName() {
        return inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public HashMap<String, Double> getAccounts() {
        return accounts;
    }

    public void setAccounts(HashMap<String, Double> accounts) {
        this.accounts = accounts;
    }

    public void initialNameRequest() throws Exception {
        System.out.println("What is your name?");
        setInputName(scanner.nextLine());

        if (inputName.equals("")) {
            throw new Exception("Failed to enter a name");
        }
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

            //throw new Exception("You said no I'm broken");
        }
    }
    public void removeAccount(){
        System.out.println("Please confirm the removal of the account for " + getInputName() + ". [Y/N]");
        if (scanner.nextLine().equalsIgnoreCase("Y")){
            getAccounts().remove(getInputName());
            System.out.println("The account for " + getInputName() + " has been removed.");
        }
        else {
            System.out.println("Your account was not removed.");

        }
    }
}

