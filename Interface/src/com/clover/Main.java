package com.clover;

public class Main {

    public static void main(String[] args) {
	// write your code here
        var calculator = new TaxCalculator2020(100_000);
        //var report = new TaxReport(calculator);
        var report = new TaxReport();

        //we can also write the dependency inside the show method because this is where dependency used
        //report.show();
        report.show(calculator);

        /*//dependency injection is easily to change the class without impact
        report.setCalculator(new TaxCalculator2021());
        report.show();*/

        report.show(new TaxCalculator2021());
    }
}
