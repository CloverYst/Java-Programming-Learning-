package com.clover;

public interface TaxCalculator {
    float minimumTax = 100;

    //because interface is just a public contract so the public keyword is unnecessary
    //public double calculateTax();
    double calculateTax();

    /*//This is the implementation details should not be in interface, so if wanna reuse should use abstract to deal it
    static double getTaxableIncome(double income, double expenses){
        return income - expenses;
    }*/
}
