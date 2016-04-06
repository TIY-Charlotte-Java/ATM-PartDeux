//package com.theironyard.clt;

import javax.security.auth.login.AccountException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by mac on 4/4/16.
 */
public class NewAccount {
    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);
        HashMap<String, Double> map = new HashMap<>();

        map.put("Michael", 200.00);
        map.put("Anthony", 300.00);
        map.put("Ben", 400.00);

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
            System.out.println("Your choice; " + choice);

        }
    }

}

