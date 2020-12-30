package com.clover;

public abstract class AbstractTaxCalculator implements TaxCalculator{
    //use protected instead of static we hide this from outside but can be use it in Classes inherit this Class
    protected double getTaxableIncome(double income, double expenses){
        return income - expenses;
    }
}
