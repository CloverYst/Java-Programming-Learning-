package com.clover;

public class TaxCalculator2021 extends AbstractTaxCalculator {//implements TaxCalculator   dont need that anymore because Abstract already did

    @Override
    public double calculateTax() {
        System.out.println(getTaxableIncome(12,8));
        return 0;
    }
}
