package com.clover;

import java.awt.*;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello World");
        long viewCount = 3_123_456_789L;
        float price = 10.99F;
        Date now= new Date();
        System.out.println(now);

        //primitive type
        byte x=1;
        byte y=x;
        x=2;
        System.out.println(y);

        //reference type
        Point point1 = new Point(1,1);
        Point point2 = point1;
        point1.x = 2;
        System.out.println(point2);

        //String
        String message = "Hello world" + "!!";
        System.out.println(message.length());
        System.out.println(message.replace("!","*"));
        System.out.println(message.toUpperCase(Locale.ROOT));
        System.out.println(message.endsWith("."));
        System.out.println(message.indexOf('l'));
        System.out.println(message.indexOf("orld"));
        String message2 = "   hello world  ";
        System.out.println(message2);
        System.out.println(message2.trim());

        //escape sequence for special character in a word
        String test1 = "you are \"beautiful\" c:\\windows\nhhhh\thh";
        System.out.println(test1);


        //arrays
        int[] numbers = new int[5];
        numbers[0] = 1;
        numbers[1] = 2;
        System.out.println(numbers);
        System.out.println(Arrays.toString(numbers));
        int[] nums = {2,1,3,5,4};
        System.out.println(nums.length);
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        //multi-dimensional array
        int[][] multiNumbers = new int[2][3];
        multiNumbers[0][0] = 1;
        System.out.println(Arrays.deepToString(multiNumbers));
        int[][][] threeNumbers = new int[2][2][2];
        threeNumbers[0][1][1] = 4;
        System.out.println(Arrays.deepToString(threeNumbers));


        //constant
        final float PI = 3.14F;

        //arithmetic expression;
        double result = (double)10/ (double)3;
        System.out.println(result);
        int x1 = 1;
        int y1 = x1++;
        int z = ++x1;
        x1 += 2;
        x1 -= 2;
        x1 *= 2;
        x1 /= 2;

        //Casting
        short xx = 1;
        int yy= xx + 1;
        System.out.println(yy);
        double a = 1.1;
        int b = (int)a + 2;
        System.out.println(b);
        String s = "3";
        int r = Integer.parseInt(s) + 4;
        System.out.println(r);


        //The Math Class
        int resultMath = Math.round(1.1F);
        System.out.println(resultMath);
        int r2 = (int)Math.ceil(1.1F);
        System.out.println(r2);
        int r3 = (int)Math.floor(1.1F);
        System.out.println(r3);
        int r4 = Math.max(1,2);
        System.out.println(r4);
        double r5 = Math.random()*100;
        System.out.println(r5);
        int r6 = (int)Math.round(Math.random()*100);
        System.out.println(r6);


        //Format number
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String currResult = currency.format(1234567.891);
        System.out.println(currResult);
        NumberFormat percent = NumberFormat.getPercentInstance();
        String perResult = percent.format(0.1);
        System.out.println(perResult);

        //Reading Input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Age:");
        byte age = scanner.nextByte();
        System.out.println("Your age is "+ age);
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Name:");
        String name = scanner2.nextLine().trim();
        System.out.println("Your name is "+ name);



        //Project--> Mortgage Calculator
        Scanner principal = new Scanner(System.in);
        System.out.print("Principal:");
        long p = principal.nextInt();
        Scanner rate = new Scanner(System.in);
        System.out.print("Annual Interest Rate:");
        double rr = rate.nextDouble()/100/12;
        Scanner period = new Scanner(System.in);
        System.out.print("Period (Years):");
        float n = period.nextInt()*12;
        double mortgage = p * (rr*Math.pow((1+rr),n)/(Math.pow((1+rr),n)-1));
        NumberFormat curr = NumberFormat.getCurrencyInstance();
        String finalResult = curr.format(mortgage);
        System.out.println("Mortgage:"+ finalResult);


    }
}
