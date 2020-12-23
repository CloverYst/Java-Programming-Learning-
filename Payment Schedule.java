package com.clover;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {
        int principal = (int)readNumber("Principal:",1000,1_000_000);
        float annualInterest = (float) readNumber("Annual Interest:",1,30);
        byte years = (byte) readNumber("Period (Years):",1,30);

        double mortgage = mortgageCalculate(principal,annualInterest,years);
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments:" + NumberFormat.getCurrencyInstance().format(mortgage));

        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for(short month = 1; month<= years*MONTHS_IN_YEAR;month++){
            double balance = paymentSchedule(principal,annualInterest,years,month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public static double readNumber(
            String prompt,
            int min,
            int max
    ){
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        double number;
        while(true){
            number = scanner.nextDouble();
            if(number>=min&&number<=max)
                break;
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return number;
    }

    public static double mortgageCalculate(
            int principal,
            float annualInterest,
            byte years
    ){
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        float numberOfPayments = years * MONTHS_IN_YEAR;
        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortgage;
    }

    public static double paymentSchedule(
            int principal,
            float annualInterest,
            byte years,
            short numberOfPay
    ){
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        float numberOfPayments = years * MONTHS_IN_YEAR;

        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPay))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        return balance;
    }
}
