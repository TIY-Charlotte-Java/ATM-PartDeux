package com.theironyard.charlotte;
import java.util.Scanner;
import java.util.HashMap;

/**
 * Created by Joe on 12/5/16.
 */
public class Atm {
        private HashMap<String, Double> accounts = new HashMap<>();

        private double amount;

        public void selectName() throws Exception {

            System.out.println("Welcome to the ATM. Please enter your name.");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();

            if (name.isEmpty()) {
                throw new Exception("You need to enter a name.");
            } else
            {System.out.println("New Account created for " + name + ". Greetings, " + name);}
            Double balance = new Double(100);
            accounts.put(name, balance);
            selectChoice(name);
        }

        public void selectChoice(String name) throws Exception {
            Double balance = accounts.get(name);
            String[] options = new String[4];

            options[0] = " 1: Check my balance.";
            options[1] = " 2: Withdraw funds.";
            options[2] = " 3: Cancel.";
            options[3] = " 4: Remove account.";

            for (String option : options) {
                System.out.println(option);
            }

            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("1")) {
                System.out.println("Your Balance is. " + (balance - amount));
                selectChoice(name);
            }
            else if (choice.equalsIgnoreCase("2")) {
                System.out.println("How much would you like to withdraw?");

                Scanner sscanner = new Scanner(System.in);
                amount = sscanner.nextDouble();

                if (balance >= amount) {
                    System.out.println("Please take your money.");
                    System.out.println("Your balance is $" + (balance - amount));
                    Double updatedBalance = (balance - amount);
                    accounts.put(name, updatedBalance);
                    selectChoice(name);
                    if (balance < amount) { throw new Exception("INSUFFICIENT FUNDS.");
                    }
                }
            }
                else if (choice.equalsIgnoreCase("3")) {
                    System.out.println("Thank you and please come again.");
                        selectName();
            }
                else if (choice.equalsIgnoreCase("4")) {
                    System.out.println("Your account has been removed.");
                    accounts.remove(name);
                    selectName();
            }
                else {
                    throw new Exception("Pick a number 1-4 next time...");
                }
            }
        }

