package com.theironyard.charlotte;

/**
 * Created by kelseynewman on 12/5/16.
 */
public class Account {
    private String name;
    public Double balance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    Account (){
        balance = 100.00;
    }

    Account (String name) {
        this.balance = 100.00;
        this.name = name;
    }

    public double makeWithdrawal() throws Exception {
        System.out.println("How much would you like to withdraw?");
        Double withdrawal = Main.scanner.nextDouble();

        if (withdrawal > 0 && withdrawal <= 100) {
            System.out.println("Please take your money.");
            setBalance(balance - withdrawal);
            System.out.println("Remaining balance is $" + getBalance());
            return balance;
        } else
            throw new Exception("Insufficient funds. Please try again.");
    }

    public double makeDeposit() {
        System.out.println("How much would you like to deposit?");
        Double deposit = Main.scanner.nextDouble();
        setBalance(balance + deposit);
        System.out.println("Your new balance is " + getBalance());
        return balance;
    }

    public void removeAccount () {
            ATM.accounts.remove(name);
            System.out.println("This account has now been removed.");
    }

    public void cancel() {
        getName();
    }

}
