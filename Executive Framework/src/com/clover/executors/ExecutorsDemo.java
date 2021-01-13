package com.clover.executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class ExecutorsDemo {
    public static void show(){
        var executor = Executors.newFixedThreadPool(2);
        System.out.println(executor.getClass().getName());
        try {
            //Executors.newSingleThreadExecutor()
            //for (var i = 0; i < 10; i++)//only 2 threads available but has 10 tasks
                var future = executor.submit(() -> {
                    //System.out.println(Thread.currentThread().getName());
                    LongTask.simulate();
                    //this executor think there wil be more tasks in the future so it's not got terminate
                    //Callable Interface
                    return 1;
                });
            //maintain a queue some task on thread 1 some on thread 2

            System.out.println("Do more work");//immediately on the terminal because the submit not gonna wait the LongTask
            try {
                var result = future.get();//this will wait LongTask
                System.out.println(result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        //in case there are exceptions before so the shutdown cannot execute need try finally block
        finally {
            executor.shutdown();//not stop current tasks will wait until all finished but will not accept new tasks
            // but shutdownNow() will force existing tasks to stop
        }
    }
}
