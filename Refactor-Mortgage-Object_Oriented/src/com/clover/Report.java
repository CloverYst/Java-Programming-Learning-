package com.clover;
import java.text.NumberFormat;

public class Report {

    private final NumberFormat currency;
    //Should not use to much static because its a single instance
    private MortgageCalculate calculate;

    public Report(MortgageCalculate calculate) {
        this.calculate = calculate;
        currency = NumberFormat.getCurrencyInstance();
    }


    public void printMortgage() {//int principal, float annualInterest, byte years
        //calculate = new MortgageCalculate(principal, annualInterest, years);// its not good to initialize the field in the method
        double mortgage = calculate.calculateMortgage();
        //"NumberFormat.getCurrencyInstance().format" this is duplicate twice in both methods
        String mortgageFormatted = currency.format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }
    public void printPaymentSchedule (){ //int principal, float annualInterest, byte years (haven't use these parameters)
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for(double balance : calculate.getRemainingBalances())
            System.out.println(currency.format(balance));
        //this is calculate each moth money we should move to MortgageCalculate Class
        /*for (short month = 1; month <= calculate.getYears() * MortgageCalculate.MONTHS_IN_YEAR; month++) {//we dont need getYears anymore
            double balance = calculate.calculateBalance(month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }*/
    }
}

