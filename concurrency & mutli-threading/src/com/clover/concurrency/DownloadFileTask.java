package com.clover.concurrency;

public class DownloadFileTask implements Runnable{
    private DownloadStatus status;

    /*public DownloadFileTask() {
        this.status = new DownloadStatus();
    }*/
    public DownloadFileTask(DownloadStatus status) {
        this.status = status;
    }

    @Override
    public void run() {
        System.out.println("Downloading a file"+ Thread.currentThread().getName());

        //pausing a Thread

        //Interrupt Thread
        for (var i=0;i<10_000;i++) {
            if(Thread.currentThread().isInterrupted())
                return;
            //System.out.println("Downloading byte" + i);
            status.incrementTotalBytes();

        }

        status.done();
        //we need to notify other threads that download is done
        synchronized (status){
            status.notifyAll();
        }

        System.out.println("Downloading Completed"+Thread.currentThread().getName());
    }

    public DownloadStatus getStatus() {
        return status;
    }
}
