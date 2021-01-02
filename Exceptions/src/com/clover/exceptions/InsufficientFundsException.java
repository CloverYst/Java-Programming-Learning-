package com.clover.exceptions;

//checked --> Exception
//Unchecked (Runtime) --> RuntimeException

public class InsufficientFundsException extends Exception{
    public InsufficientFundsException(){
        super ("Insufficient funds in your account");
    }

    public InsufficientFundsException(String message){
        super(message);
    }
}
