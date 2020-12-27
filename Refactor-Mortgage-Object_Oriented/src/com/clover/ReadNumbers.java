package com.clover;

import java.util.Scanner;

public class ReadNumbers {

    private static Scanner scanner = new Scanner(System.in);

    public static double read (String prompt,double min, double max){
        //Scanner scanner = new Scanner(System.in); we don't wanna every time create a new scanner
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;
    }
    //method overloading
    public static double read (String prompt){
        //Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

}
