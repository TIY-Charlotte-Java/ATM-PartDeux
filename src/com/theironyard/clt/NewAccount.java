package com.theironyard.clt;

import javax.security.auth.login.AccountException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by mac on 4/4/16.
 */
public class NewAccount {
    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);
        HashMap<Integer, AccountException> accountExceptionHashMap = new HashMap<Integer, AccountException>();

            //Options
        while (true) {

            System.out.println("Enter the option for the operation you need;");
            System.out.println("*****************************************************");
            System.out.println("[ Options: ne - New Account de - Delete Account ]");
            System.out.println("[       dp - Deposit    wi - Withdraw       ]");
            System.out.println("            se - Select Account ex - Quit        ]");
            System.out.println("*****************************************************");
            System.out.println("> ");   //indicator for user input

            String choice = input.next();
            System.out.println();("Your choice; " + choice);

            if(choice.equals("ne")) {
                Integer newAccountNumber;
                Double intialBalance;
                AccountException newAccount;

                // Array for account and balance
                System.out.print("Insert account number: ");
                newAccountNumber = input.nextInt(); //-- Input nr array insertion
                System.out.print("Enter initial balance: ");
                intialBalance=input.nextDouble(); //Input nr array insertion
                newAccount = new AccountException(newAccountNumber, intialBalance);
                accountExceptionHashMap.put(newAccountNumber, newAccount);
                System.out.println("New Account " + newAccountNumber + " created with balance: " + intialBalance);

            }
            // select account
            else if(choice.equals("se")) {
                System.out.println("");
            }

        }



    }
}
