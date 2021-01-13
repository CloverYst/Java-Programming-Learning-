package com.clover;

import com.clover.executors.CompletableFuturesDemo;
import com.clover.executors.ExecutorsDemo;
import com.clover.executors.MailService;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //ExecutorsDemo.show();
        CompletableFuturesDemo.show();

        var service = new MailService();
        //service.send();//this is blocking code
        service.sendAsync();//mail was send on separate thread
        System.out.println("Hello User!");//Have to wait the send() email finished
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }//this sleep help to prove that the mail was send
    }
}
