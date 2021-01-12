package com.clover.concurrency;

import java.util.*;

public class ThreadDemo {
    public static void show(){
        System.out.println(Thread.currentThread().getName());//getId()

        //Thread thread = new Thread(new DownloadFileTask());
        //thread.start();//start and kill auto

        //if u have another Thread which is used to scan file but u have to wait until the file is download
        //join()
       /* try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("File is ready to be scanned!");*/


        //interrupt a Thread
        /*try {
            thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();*/



        //Race Conditions
        //use confinement to solve the problem
        /*List<Thread> threads = new ArrayList<>();
        //var status = new DownloadStatus();  //in order to avoid the race condition we can give each download thread a status
        List<DownloadFileTask> tasks = new ArrayList<>();
        for (var i=0;i<10;i++){
            var task = new DownloadFileTask();
            tasks.add(task);

            var threadRace = new Thread(task);
            threadRace.start();
            threads.add(threadRace);
        }
        //iterate all the threads and join them
        for(var t:threads){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //need to combine the total bytes across these tasks
        var sum= tasks.stream()
                .map(t->t.getStatus().getTotalBytes())
                .reduce(0,(a,b)->a+b); //reduce(Integer::sum)
        System.out.println(sum);*/

        //Use Lock to solve the problem
        /*List<Thread> threads = new ArrayList<>();
        var status = new DownloadStatus();
        for (var i=0;i<10;i++){
            var threadRace = new Thread(new DownloadFileTask(status));
            threadRace.start();
            threads.add(threadRace);
        }
        //iterate all the threads and join them
        for(var t:threads){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(status.getTotalBytes());*/

        //The violate keyword
        //Threads signalling with wait() and notify()
        /*var status = new DownloadStatus();
        var thread1 = new Thread(new DownloadFileTask(status));
        var thread2 = new Thread(()->{
            while(!status.isDone())//{}//waste the cpu because while loop will keep running 1_000_000times
            {
                synchronized (status){
                    try {
                        status.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(status.getTotalBytes());
        });
        thread1.start();
        thread2.start();//thread1 finish but thread2 will forever because isDone() is not synchronized
        //the change of fields should be visible across threads*/

        //Atomic Object
        List<Thread> threads = new ArrayList<>();
        var status = new DownloadStatus();
        for (var i=0;i<10;i++){
            var threadRace = new Thread(new DownloadFileTask(status));
            threadRace.start();
            threads.add(threadRace);
        }
        //iterate all the threads and join them
        for(var t:threads){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(status.getTotalBytes());



        //Synchronized Collection
        //share collection across multiple threads
        //Collection<Integer> collection = new ArrayList<>(); //just get [4,5,6] lost other because two threads try to access same time
        Collection<Integer> collection = Collections.synchronizedCollection(new ArrayList<>());
        var thread1 = new Thread(()->{
            collection.addAll(Arrays.asList(1,2,3));
        });
        var thread2 = new Thread(()->{
            collection.addAll(Arrays.asList(4,5,6));
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(collection);
    }
}

