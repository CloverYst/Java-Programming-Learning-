package com.clover.concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatus {
    private volatile boolean isDone;

    //private int totalBytes;
    //Atomic Objects
    //private AtomicInteger totalBytes = new AtomicInteger();
    //if u have multiple threads modify frequently use Adder which more fast than Atomic
    private LongAdder totalBytes = new LongAdder();
    //private Lock lock = new ReentrantLock();
    private  int totalFiles;
    private Object totalBytesLock = new Object();
    private Object totalFilesLock = new Object();

    public void incrementTotalBytes(){
        /*lock.lock();
        try {
            totalBytes++;
        }
        //write to the main memory and store in CPU
        //CPU increments the value
        //then the updated value will be stored in the memory
        //three steps non-automatically
        //but threads are concurrency so they lost to read the updated value
        finally {
            lock.unlock();
        }*/

        //totalBytes++;

        /*synchronized (totalBytesLock){ //if synchronized(this)
            totalBytes++;
        }*/

        //Atomic
        //totalBytes.incrementAndGet();//++a

        //Adder
        totalBytes.increment();
    }

    public  void incrementTotalFiles() { //if synchronized(this)
        synchronized (totalFilesLock) {  //has problem because there are two different fields but one same modifier objects
            totalFiles++;    //so if one thread access the totalBytes another field cannot change the totalFiles field
        }
    }
    /*public int getTotalBytes(){
        return totalBytes;
    }*/
    public int getTotalBytes(){
        //Atomic
        //return totalBytes.get();
        //Adder
        return totalBytes.intValue();
    }

    public int getTotalFiles() {
        return totalFiles;
    }
    public boolean isDone() {
        return isDone;
    }

    public void done() {
        isDone = true;
    }
}
