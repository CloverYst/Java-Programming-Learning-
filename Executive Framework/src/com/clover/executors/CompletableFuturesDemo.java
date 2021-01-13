package com.clover.executors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class CompletableFuturesDemo {
    public static int toFahrenheit(int celsius){
        return (int)(celsius*1.8+32);
    }

    public static CompletableFuture<String> getUserEmailAsync(){
        return CompletableFuture.supplyAsync(()->"email");
    }
    public static CompletableFuture<String> getPlaylistAsync(String email){
        return CompletableFuture.supplyAsync(()->"playlist");
    }

    public static void show(){
        //create a CompletableFuture object
        Runnable task1 = ()-> System.out.println("aaa");
        //runAsync(runnable) : this will use commonPool /runAsync(runnable, Executor)
        var future1 = CompletableFuture.runAsync(task1);

        Supplier<Integer> task2 = ()->1;
        var future2 = CompletableFuture.supplyAsync(task2);
        try {
            var result2 = future2.get();
            System.out.println(result2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //running code on a completion
        var future3 = CompletableFuture.supplyAsync(()->1);
        future3.thenRun(()->{
            System.out.println(Thread.currentThread().getName());
            System.out.println("Future3 Done");
        }); //thenRun() method from CompletionStage and run in main Thread
        future3.thenRunAsync(()->{
            System.out.println(Thread.currentThread().getName());
            System.out.println("Future3 Done");
        });//run on a separate Thread
        future3.thenAccept(result->{
            System.out.println(Thread.currentThread().getName());
            System.out.println(result);
        });
        future3.thenAcceptAsync(result->{
            System.out.println(Thread.currentThread().getName());
            System.out.println(result);
        });
        //because main thread finish fast so in order to see the thenAcceptAsync print result we need to
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Handling Exceptions
        var future4 = CompletableFuture.supplyAsync(()->{
            System.out.println("Getting the current temperature and location...");
            throw new IllegalStateException();
        });
        try {
            //future4.get();
            var result4 = future4.exceptionally(ex->"error").get();
            System.out.println(result4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        //Transforming a CompletionFuture
        //in order to simplify the code can create a method
        var future5 = CompletableFuture.supplyAsync(()->20);
        try {
            var result5 = future5
                    //.thenApply(celsius->(celsius*1.8+32))
                    .thenApply(CompletableFuturesDemo::toFahrenheit)
                    .get();
            System.out.println(result5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        future5.thenApply(CompletableFuturesDemo::toFahrenheit).thenAccept(f-> System.out.println(f));


        //Composing a completion futures
        //the second thread will start upon the finish of the first thread
        //1.user ID->email
        var future6 = CompletableFuture.supplyAsync(()->"email");//in real condition, should go to the
        //database to find the user email
        //2.email->playlist
        future6.thenCompose(email->CompletableFuture.supplyAsync(()->"playlist"))
                .thenAccept(playlist-> System.out.println(playlist));
        //Another easy clear way to write the code
        //CompletableFuture.supplyAsync(()->"email").thenCompose(email->CompletableFuture.supplyAsync(()->"playlist"))
        //                .thenAccept(playlist-> System.out.println(playlist));
        //in real condition, there will be two methods used to find email and playlist
        getUserEmailAsync()
                .thenCompose(CompletableFuturesDemo::getPlaylistAsync)
                .thenAccept(playlist-> System.out.println(playlist));


        //Combining Completion Futures
        //two tasks execute asynchronously then combine the results together
        //var first = CompletableFuture.supplyAsync(()->20);
        var first = CompletableFuture.supplyAsync(()->"20USD")
                .thenApply(str->{
                    var price = str.replace("USD","");
                    return Integer.parseInt(price);
                });
        var second = CompletableFuture.supplyAsync(()->0.9);
        first.thenCombine(second,(price,rate)->price*rate)
                .thenAccept(result-> System.out.println(result));


        //waiting for many tasks to complete
        var taskOne = CompletableFuture.supplyAsync(()->1.1);
        var taskTwo = CompletableFuture.supplyAsync(()->2.2);
        var taskThree = CompletableFuture.supplyAsync(()->3.3);
        var all = CompletableFuture.allOf(taskOne,taskTwo,taskThree);
        all.thenRun(()->{
            try {
                var firstResult = taskOne.get();
                System.out.println(firstResult);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println("All tasks completed!");
        });

        //waiting for the first task
        var t1 = CompletableFuture.supplyAsync(()->{
            LongTask.simulate();
            return 200;
        });
        var t2 = CompletableFuture.supplyAsync(()->200);
        CompletableFuture.anyOf(t1,t2)
                .thenAccept(r-> System.out.println(r));

        //Timeout
        var future7 = CompletableFuture.supplyAsync(()->{
            LongTask.simulate();
            return 777;
        });

        try {
            var result7 =future7
                    .completeOnTimeout(5777,1,TimeUnit.SECONDS)
                    //.orTimeout(1, TimeUnit.SECONDS)//this will throw exception after 1 second
                    .get();
            System.out.println(result7);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
