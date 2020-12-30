package com.clover;

public class TaxReport {
    //tightly-coupled code because we use TaxCalculator Class so if this changes report class will be affected
    //private TaxCalculator2020 calculator;   //not depend on another class should depend on an interface
    private TaxCalculator calculator;

    /*//Constructor Injection
    //get rid of the new statement we dont want the TaxReport to know any concrete implementation
    public TaxReport(TaxCalculator calculator) {
       // this.calculator = new TaxCalculator2020(100_000);
        this.calculator = calculator;
    }*/

    //Method Injection
    public void show(TaxCalculator calculator){
        var tax =calculator.calculateTax();
        System.out.println(tax);
    }

    /*//Setter Injection
    public void setCalculator(TaxCalculator calculator) {
        this.calculator = calculator;
    }*/
}
