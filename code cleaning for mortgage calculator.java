package com.clover;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        greetUser("Clover","Yst");

        /*int principal = 0;
        float annualInterest = 0;
        byte years = 0;*/

        int principal = (int)readNumber("Principal:",1000,1_000_000);
        float annualInterest = (float) readNumber("Annual Interest:",1,30);
        byte years = (byte) readNumber("Period (Years):",1,30);

        double mortgage = mortgageCalculator(principal,annualInterest,years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }

    //new greet method use public access mode meaning can be accessed outside the class
    public static void greetUser(String firstName, String lastName){ //give a input of this method which is the name of user
        System.out.println("Hello "+ firstName + " " + lastName);
    }

    //refactor mortgage calculator with new method
    public static double mortgageCalculator (
            int principal,
            float annualInterest,
            byte years
    ){
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        return mortgage;
    }

    //refactor repetitive part while loop for the scanner type we can casting double to others
    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextFloat();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between" + min + " and " + max);
        }
        return value;
    }
}
