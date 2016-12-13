package com.theironyard.charlotte;

public class Main {

    public static void main(String[] args) {
        ATM atm = new ATM();

        while (true) {
            String person = ATM.selectName();

            // see if the atm has a person account.
            // if not, make a new account and store it
            // in the atm.
            atm.accounts.putIfAbsent(person, new Account(person));

            // set the atm's current account to the person's
            // Account
            atm.setCurrentAccount(atm.accounts.get(person));

            Account currentAccount = atm.getCurrentAccount();

            while (atm.getCurrentAccount() != null) {
                switch (ATM.makeSelection()) {
                    case 1:
                        ATM.printBalance(currentAccount);
                        break;
                    case 2:
                        ATM.depositFunds(currentAccount);
                        break;
                    case 3:
                        ATM.withdrawFunds(currentAccount);
                        break;
                    case 4:
                        ATM.removeAccount(atm);
                        break;
                    case 5:
                        ATM.signOut(atm);
                        break;
                }
            }
        }
    }
}
