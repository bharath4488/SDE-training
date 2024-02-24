package com.basics.amazon.learnThreads;

public class Runnable1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread() + " iteration " + i);
//            Thread.currentThread().stop(); // stop thread
        }
        System.out.println("Thread execution done!");
    }
    public void printThread() {
        System.out.println(Thread.currentThread());
    }
}
