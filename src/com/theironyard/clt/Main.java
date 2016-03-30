package com.theironyard.clt;

/**
 * Created by Ben on 3/30/16.
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("Hello, please enter your name.");
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        




        // quick note: throwing exceptions
        // you can throw a new one with this:
        // throw new IllegalArgumentException("Message About Exception");

        // You will need this in a couple places in your code.
        // We will discuss more about exceptions in the coming days.
    }
}
