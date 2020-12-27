package com.clover;


import java.text.NumberFormat;

public class MortgageCalculate {
    private int principal;
    private float annualInterest;
    private byte years;

    //not used outside of this class
    private final static byte MONTHS_IN_YEAR = 12;
    private final static byte PERCENT = 100;


    public MortgageCalculate(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double calculateMortgage(){

        //we have duplicate this two lines twice in both methods
        float monthlyInterest = getMonthlyInterest();
        float numberOfPayments = getNumberOfPayments();

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortgage;
    }



    public double calculateBalance (short numberOfPaymentsMade){
        float monthlyInterest = getMonthlyInterest();
        float numberOfPayments = getNumberOfPayments();

        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return balance;
    }

    public double[] getRemainingBalances(){
        double[] balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= balances.length; month++)  //getNumberOfPayments()
            //double balance = calculateBalance(month); use Refactor--> inline to move
            balances[month-1]= calculateBalance(month);
        return balances;
    }

    //Interfaces of this class
   /* public short getYears() {
        return years;
    }*/
    private int getNumberOfPayments() {
        return years * MONTHS_IN_YEAR;
    }
    private float getMonthlyInterest() {
        return annualInterest / PERCENT / MONTHS_IN_YEAR;
    }
}
