package com.theironyard.charlotte;

import java.util.Scanner;

/**
 * Created by guest on 12/1/16.
 */
public class Person {

    private static final Scanner scanner = new Scanner(System.in);

    public void provideName()throws Exception {
        System.out.println("What is your name?");
        String name = scanner.nextLine();

        if (name.equalsIgnoreCase("")) {
            throw new Exception("You must provide a name.");
        } else {
            System.out.println("Hello, " + name + ".");
        }
    }
}