package com.clover;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
        public static void main (String[]args){

            int principal = (int) ReadNumbers.read("Principal: ", 1000, 1_000_000);
            float annualInterest = (float) ReadNumbers.read("Annual Interest Rate: ", 1, 30);
            byte years = (byte) ReadNumbers.read("Period (Years): ", 1, 30);

            var calculate = new MortgageCalculate(principal,annualInterest,years);

            var report = new Report(calculate);
            report.printMortgage();
            report.printPaymentSchedule();

        }
}
