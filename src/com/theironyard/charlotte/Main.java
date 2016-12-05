package com.theironyard.charlotte;

public class Main {

    public static void main(String[] args) throws Exception {
        Account one = new Account();

        System.out.println("Welcome to Java National Bank!");

        one.setBalance(100.00);
        one.selectName();
        one.selectOption();

    }
}