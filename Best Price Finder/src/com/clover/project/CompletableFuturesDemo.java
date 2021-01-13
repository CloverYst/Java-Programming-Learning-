package com.clover.project;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class CompletableFuturesDemo {
    public static void show(){
        var start = LocalTime.now();
        var service = new FlightService();
        /*service.getQuote("site1")
        .thenAccept(System.out::println);*/

        var futures =service.getQuotes()
                //.stream()
                .map(future-> future.thenAccept(System.out::println))
                .collect(Collectors.toList());
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(()->{
                    var end = LocalTime.now();
                    var duration = Duration.between(start, end);
                    System.out.println("Retrieved all quotes in " + duration.toMillis()+" msec.");
                });
        //wait the async to finish
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
