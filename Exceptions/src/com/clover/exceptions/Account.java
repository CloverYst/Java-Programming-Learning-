package com.clover.exceptions;

import java.io.IOException;

public class Account {
    private int balance;

    public void deposit(float value) throws IOException{
        if (value <= 0)
            //throw new IllegalArgumentException();
            throw  new IOException(); //we should handle it so add throws on the top
    }

    //public void withdraw(float value) throws InsufficientFundsException {
    public void withdraw(float value) throws AccountException {
        if(value > balance) {
            /* throw new InsufficientFundsException();//throw an exception here but wanna handle it somewhere else*/
            //var fundsException = new InsufficientFundsException();
            var accountException = new AccountException(new InsufficientFundsException());
            //accountException.initCause(fundsException);
            throw accountException;
        }
    }
}
