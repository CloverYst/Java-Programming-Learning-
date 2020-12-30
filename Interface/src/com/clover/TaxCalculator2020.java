package com.clover;

//interface keyword is implements. A class can extends one class but implements many interfaces
public class TaxCalculator2020 implements TaxCalculator{
    private double taxableIncome;

    public TaxCalculator2020(double taxableIncome) {

        this.taxableIncome = taxableIncome;
    }



    @Override
    public double calculateTax(){
        // TaxCalculator.minimumTax = 1000; not allowed do that because it is final static constant can not be changed
        return taxableIncome*0.3;
    }
}
