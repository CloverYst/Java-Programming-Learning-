package com.clover;

import com.clover.exceptions.ExceptionsDemo;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
            ExceptionsDemo.show();
        }
        catch (Throwable e) {
        //catch (IOException e) {
            //e.printStackTrace();
            System.out.println("An unexpected error occur.");
        }
    }
}
