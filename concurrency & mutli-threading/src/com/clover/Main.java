package com.clover;

import com.clover.concurrency.ThreadDemo;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(Thread.activeCount());
        System.out.println(Runtime.getRuntime().availableProcessors());

        ThreadDemo.show();
    }
}
