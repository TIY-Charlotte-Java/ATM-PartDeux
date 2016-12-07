package com.theironyard.charlotte;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by emileenmarianayagam on 12/7/16.
 */
public class ATM {
    int answer;
    private String name;
    int choice;

    HashMap<String, Double> newAccount = new HashMap<>();
    Accounts account = new Accounts();

    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public void createPerson() throws Exception {
        Scanner input = new Scanner(System.in);

        newAccount.put("emileen", account.getBalance());
        newAccount.put("alicia", account.getBalance());
        newAccount.put("felicia", account.getBalance());


        while (true) {
            System.out.println("Please enter your first name");
            setName(input.nextLine());
            if (!getName().equals("")) {

                if (!newAccount.containsKey(getName())) {
                    System.out.println("You did not have an account -- one has been created ");
                    System.out.println("Welcome " + getName());
                    newAccount.put(getName(), account.getBalance());
                    option();
                } else {
                    System.out.println("This name already exists");
                    newAccount.put(getName(), account.getBalance());

                }
            } else {

                throw new Exception("you have a blank entry -- cant accept");
            }

            for (Map.Entry m : newAccount.entrySet()) {
                System.out.println(m.getKey() + " " + m.getValue());
            }

        }

    }

    public void option() throws Exception {

        do {

            Scanner input = new Scanner(System.in);
            System.out.println("-- What would you like to do -- ");
            System.out.println("1. Check my balance ");
            System.out.println("2. Withdrawl Funds ");
            System.out.println("3. Deposit Funds");
            System.out.println("4. Delete Account");
            System.out.println("5. Cancel");

            choice = input.nextInt();

            if (choice == 1) {
                account.printBalance();
            } else if (choice == 2) {
                account.amountWithdrawn();

            } else if (choice == 3) {
                account.deposit();

            } else if (choice == 4) {
                account.deleteAccount();

                System.out.println("Account has been removed");
            } else {
                System.out.println("Thank you and Please come again");
            }
            if (choice != 5) {
                System.out.println("would you like to complete more transactions-- 1 Yes -- 2 No");
                answer = input.nextInt();
            }

        } while (answer == 1);
    }
}
