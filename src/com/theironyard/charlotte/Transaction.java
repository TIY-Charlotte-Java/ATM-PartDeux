package com.theironyard.charlotte;


/**
 * Created by graceconnelly on 12/1/16.
 */
public class Transaction {
    //Static transaction methods
    public static void correctCoinage(double withdrawalAmt) {
        double totalBills = 0;

        int[][] coinage = {
                {10000, 2000, 1000, 500, 100, 25, 10, 5, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}};

        String[] coinageName = {"One Hundred dollar bills", "Twenty dollar bill(s)", "Ten dollar bill(s)", "Five dollar bills(s)", "One dollar bill(s)",
                "Quarter(s)", "Dime(s)", "Nickel(s)", "Penny(ies)"};
        //This code breaks down monies received
        System.out.println("You have received $" + (withdrawalAmt) + " broken down by:");
        for (int i = 0; i < coinage[0].length; i++) {

            totalBills = totalBills*(double)100;
            totalBills = Math.round(totalBills);
            totalBills = totalBills/(double)100;

            coinage[1][i] = (int)((withdrawalAmt*100 - totalBills) / coinage[0][i]);
            totalBills = (totalBills + (coinage[1][i] * coinage[0][i]));
            if (coinage[1][i] != 0) {
                System.out.println(coinage[1][i] + "  " +coinageName[i]);
            }
        }
    }
}
