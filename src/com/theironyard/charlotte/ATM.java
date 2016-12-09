package com.theironyard.charlotte;

import java.util.HashMap;


/**
 * Created by kelseynewman on 12/1/16.
 */
public class ATM {
    public static HashMap<String, Account> accounts = new HashMap<>();
    private Account currentAccount;

    public Account getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(Account currentAccount) {
        this.currentAccount = currentAccount;
    }

    public Account getAccount(String name) {
        return accounts.get(name);
    }

    public void addAccount(Account account) {
        accounts.put(account.getName(), account);
    }

}


