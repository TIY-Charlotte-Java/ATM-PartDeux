package com.theironyard.charlotte;

//

public class Main {

    public static void main(String[] args) throws Exception {
        //booleans to control loops
        boolean canceled;
        boolean poweredOff = false;
        //Call up scanner
       // Scanner scanner = new Scanner(System.in);

        //Create new instance for user account and transaction
        Account user = new Account();

        while (!poweredOff) {
            canceled = false;

            //Asks user for their name
            user.initialNameRequest();
            //user.setInputName(scanner.nextLine());
            if (user.getInputName().equals("")){
                continue;
            }
            //resets all accounts ends program
            if (user.getInputName().equalsIgnoreCase("escape")){
                poweredOff = true;
                break;
            }

            //Checks if user name exists. If it does it will set class Transaction's balance to balance stored in account.
            // If it doesn't then it will return null, and request user to create a new account. If they don't create a new account
            // it asks for a new name.
            if (user.getAccounts().get(user.getInputName()) == null) {
                user.createAccount();
                if(user.getInputName().equals("")){
                    //canceled = true;
                    continue;
                }
                else {
                    System.out.println("Welcome " + user.getInputName());
                }

            }
            while (!canceled) {
                user.chooseEvent();
                switch (user.getSelection()) {
                    case 1: {
                        //print balance
                        System.out.println("WOW! Your current balance is $" + user.getAccounts().get(user.getInputName()));
                        break;
                    }
                    case 2: {
                        //deposit funds
                        user.depositFunds();
                        break;
                    }
                    case 3: {
                        //withdraw funds
                        user.withdrawFunds();
                        break;
                    }
                    case 4: {
                        //remove account
                        user.removeAccount();
                        if (user.getAccounts().get(user.getInputName()) == null){
                            canceled = true;
                    }
                        break;
                    }
                    case 5: {
                        //Transfer funds
                        user.transferMoney();
                        break;
                    }
                    case 6: {
                        //cancel
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