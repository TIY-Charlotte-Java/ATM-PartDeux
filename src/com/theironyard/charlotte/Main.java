package com.theironyard.charlotte;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Person p = new Person();
        ATM t = new ATM();
        ATM task = new ATM();

        Scanner scanner = new Scanner(System.in);

        p.provideName();
        t.getBalance();
        t.selectTask();
      //  ATM.changeReturned(t.getBalance());

        do {
            System.out.println("What would you like to do now? Select 1 - check balance, 2 - make a withdrawal or 3 - cancel.");
            String nextTask = scanner.nextLine();

            if (nextTask.equals("1")) {
                System.out.println(t.getBalance());
            } else if (nextTask.equals("2")) {
                t.makeWithdrawal();
            } else if (nextTask.equals("3")) {
                System.out.println("Thank you. Please come again.");
                t.exitProgram();
            } else
                throw new Exception ("Invalid selection. Please try again.");
        } while (!(task.equals("3")));
    }
}