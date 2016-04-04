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
                System.out.println("Enter number of account to be selected: ");
                Integer accounttoGetNumber = input.nextInt();
                AccountException returnedAccount = accountExceptionHashMap.get(accounttoGetNumber);
                if (returnedAccount != null)
                {
                    System.out.println("Account open. Current balance: " + returnedAccount.getBalance());
                }
                else
                {
                    //user input for account nr from array
                    System.out.println("Account does not exist.");
                }
            }

        }
        //close account
        else if (choice.equals("de"))
        {
            System.out.println("Enter number of account to be selected: ");
            Integer accountToDeleteNumber = input.nextInt();
            AccountException removedAccount = accountExceptionHashMap.remove(accountToDeleteNumber);
            if (removedAccount != null)
            {
                System.out.println("Account " + removedAccount.getAccountNumber() + "has been closed with balance: " + removedAccount.geBalance());
            }
            else
            {
                //user input for account nr from array
                System.out.println("Account does not exist.");
            }
        }
        // deposit
        else if (choice.equals("dp")) {
            System.out.println("Enter number of account to deposit: ");
            Integer accountToDeposit = input.nextInt();
            System.out.print("Enter ammount to deposit: ");
            double amount = input.nextDouble();
            if(amount <= 0){
                System.out.println("You must deposit an amount greater than 0.");
            } else {
                accountExceptionHashMap.get(accountToWithdraw).withdraw(amount);
                System.out.println();("You have deposited " + (amount));
                System.out.println("Current balance " + accountExceptionHashMap.get(accountToWithdraw).getBalance());
            }
        }
        //quit
        else if (choice.equals("ex")) {
            break;
        } else {
            System.out.println("Wrong option.");
        } //end of loop

        input.close();
    } //end of main
} //end of class
