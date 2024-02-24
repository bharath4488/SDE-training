package com.basics.amazon.learnThreads;

public class Thread1 extends Thread{

    public Thread1(String threadName) {
        super(threadName); // pass thread name to Thread class
    }

    @Override
    public void run(){
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread() + " iteration " + i);
//            Thread.currentThread().stop(); // stop thread
        }
        System.out.println("Thread execution done!");
    }

}
