package com.theironyard.charlotte;

public class Main {

    public static void main(String[] args) throws Exception {
        Account one = new Account();

        System.out.println("Welcome to Java National Bank!");
        one.createAccount();
        one.selectOption();

    }
}