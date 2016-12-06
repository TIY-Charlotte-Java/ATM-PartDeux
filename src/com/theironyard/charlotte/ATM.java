package com.theironyard.charlotte;

public class ATM {

    public static void main(String[] args) throws Exception {


        System.out.println("Greetings, Bank Member!");

        boolean canceled;
        boolean poweredOff = false;

        Account user = new Account();
        Transaction transaction = new Transaction();


        while (!poweredOff) {
            canceled = false;

            //Asks user for their name
            user.initialNameRequest();

            //resets all accounts ends program
            if (user.getInputName().equalsIgnoreCase("escape")){
                poweredOff = true;
                break;
            }

            //Checks if user name exists. If it does it will set class Transaction's balance to balance stored in account.
            // If it doesn't then it will return null, and request user to create a new account. If they don't create a new account
            // it asks for a new name.
            transaction.setBalance(user.getAccounts().get(user.getInputName()));
            if (transaction.getBalance() == null) {
                user.createAccount();
                transaction.setBalance(user.getAccounts().get(user.getInputName()));
                if(user.getInputName().equals("")){
                    canceled = true;
                }

            }
            while (!canceled) {
                transaction.chooseEvent();
                switch (transaction.getSelection()) {
                    case 1: {
                        System.out.println("WOW! Your current balance is $" + transaction.getBalance());
                        break;
                    }
                    case 2: {
                        transaction.setBalance(user.getAccounts().get(user.getInputName()));
                        transaction.withdrawFunds();
                        user.getAccounts().put(user.getInputName(),transaction.getBalance());
                        break;
                    }
                    case 3: {
                        user.removeAccount();
                    }
                    case 4: {
                        //Transfer funds
                        System.out.println("Man oh man I just can't move your money right now!");
                    }
                    case 5: {
                        System.out.println("Canceling");
                        System.out.println("Thank you, please come again");
                        canceled = true;
                        break;
                    }
                    default: {
                        System.out.println("This is an invalid selection.");
                        break;
                    }
                }
            }
        }
    }
}