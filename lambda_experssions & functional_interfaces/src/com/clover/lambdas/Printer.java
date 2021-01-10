package com.clover.lambdas;

//interface just has one abstract method --> functional interface
public interface Printer {
    void print(String message);

    //this is not good for interface which should not have detail
    /*//Java introduces default method in interfaces these default method can have implementation
    default void printTwo(String message){
        System.out.println(message);
        System.out.println(message);
    }*/
}
