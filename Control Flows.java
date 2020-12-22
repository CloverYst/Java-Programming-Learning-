package com.clover;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //comparison operation logical operation
        int temperature = 22;
        boolean isWarm = temperature > 20 && temperature < 30;
        System.out.println(isWarm);
        boolean hasHighIncome = true;
        boolean hasGoodCredit = true;
        boolean hasCriminalRecord = false;
        boolean isEligible = (hasHighIncome || hasGoodCredit) && !hasCriminalRecord;
        System.out.println(isEligible);

        //if statement
        int temp = 32;
        if(temp > 30){
            System.out.println("It's a hot day!");
            System.out.println("Drink water");
        } else if(temp > 20 && temp <30){
            System.out.println("Beautiful Day");
        } else{
            System.out.println("it's cold");
        }

         //more good way to write
         if(temp > 30){
            System.out.println("It's a hot day!");
            System.out.println("Drink water");
        }
        else if(temp > 20)
            System.out.println("Beautiful Day");
        else
            System.out.println("it's cold");


        //simplify if statement
        int income = 120_000;
        boolean highIncome = (income > 100_000);


        //The Ternary Operator
        int inCome = 120_000;
        String className = inCome > 100_000? "First" : "Economy";

        //Switch Statement
        String role = "admin";
        switch(role){
            case "admin":
                System.out.println("You are an admin");
                break;
            case "moderator":
                System.out.println("You are a moderator");
                break;
            default:
                System.out.println("You are a guest");
        }

        //FizzBuzz interview question
        Scanner numIn = new Scanner(System.in);
        System.out.print("Number: ");
        int number = numIn.nextInt();
        if (number % 5 ==0){
            if (number % 3 ==0)
                System.out.println("FizzBuzz");
            else
                System.out.println("Fizz");
        }
        else if (number % 3==0)
            System.out.println("Buzz");
        else
            System.out.println(number);


        //For Loops which is used when u know how many times the loop are
        for (int i = 0; i < 5; i++){
            System.out.println("hi how are u"+ i);
        }
        //While loop is used when the exact loop times is unknown
        String input = "";
        Scanner scanner = new Scanner(System.in);
        while(!input.equals("quit")){
            System.out.print("Input:");
            input = scanner.next().toLowerCase();
        }
        //Do..While at least will execute once
        do{
            System.out.print("Input:");
            input = scanner.next().toLowerCase();

        }while(!input.equals("quit"));

        // break & contine
        while(true){
            System.out.print("Input:");
            input = scanner.next().toLowerCase();
            if(input.equals("pass"))
                continue;
            if(input.equals("quit"))
                break;//becasue there is a break statement so we dont need the exit condition in the while
            System.out.println(input);
        }

        //For Each loop
        String[] fruits = {"apple","mango", "orange"};
        for(String fruit: fruits)
            System.out.println(fruit);

        //project more conditions about mortgage calculator
        final int month = 12;
        final int ratePercent = 100;
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Principal ($1k-$1M):");
        int Principal = scanner1.nextInt();
        while(!(Principal>=1_000&&Principal<=1_000_000))
        {
            System.out.println("Enter a number between 1,000 and 1,000,000");
            System.out.print("Principal ($1k-$1M):");
            Principal = scanner1.nextInt();
        }
        System.out.print("Annual Interest Rate:");
        float rate = scanner1.nextFloat();
        while(!(rate>0&&rate<=30))
        {
            System.out.println("Enter a value greater than 0 and less than or equal to 30");
            System.out.print("Annual Interest Rate:");
            rate = scanner1.nextFloat();
        }
        rate = rate/month/ratePercent;
        System.out.print("Period (Years):");
        int year = scanner1.nextInt();
        while(!(year>=0&&year<=30))
        {
            System.out.println("Enter a value between 1 and 30");
            System.out.print("Period (Years):");
            year = scanner1.nextInt();
        }
        int n = year*month;
        double mortgage = Principal*((rate*Math.pow(1+rate,n))/(Math.pow(1+rate,n)-1));
        System.out.println("Mortgage:"+ NumberFormat.getCurrencyInstance().format(mortgage));



    }
}
