package com.basics.amazon.learnThreads;

import com.basics.amazon.learnCollections.Stack;
import com.basics.amazon.learnCollections.BlockingQueue;

import java.time.LocalTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LearnThreads {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("\n---- " + LearnThreads.class.getName() + " starting ----\n");

// -BASICS--------------------------------------------------------------------------------------------------------------

        Thread1 thread1 = new Thread1("UserThread1"); // user thread.
//        thread1.setDaemon(true); // tells jvm that this object is a daemon thread.
//        thread1.start();

        Runnable runnable1 = new Runnable1(); // user thread.
        // Thread.class has constructor with Runnable parameter
        Thread thread2 = new Thread(runnable1, "UserRunnableThread1");
//        thread2.start();
//        runnable1.printThread();

        // using lambda function
        Runnable runnable2 = new Thread(() -> System.out.println("Lambda thread"));
        Thread thread3 = new Thread(runnable2, "UserLambdaRunnableThread3");
//        thread3.start();

// -BASICS-END----------------------------------------------------------------------------------------------------------
// -SYNCHRONIZATION-----------------------------------------------------------------------------------------------------

        Stack stack = new Stack(5);

        /* the below snippets might sometimes fail.
           The reason is, pusher pushes the value and by the time it increases the index,
           popper pops the value and decreases the index
           This could cause index out of bounds exception.
         */
//        new Thread(() -> {
//            int counter= 0;
//            while (counter++ < 10)
//                stack.push(100);
//        }, "pusher").start();
//
//        new Thread(() -> {
//            int counter= 0;
//            while (counter++ < 10)
//                stack.pop();
//        }, "popper").start();

        BlockingQueue queue = new BlockingQueue(5);

//        new Thread(() -> {
//            int counter= 0;
//            while (counter++ < 10)
//                queue.add(counter);
//        }, "publisher").start();
//
//        new Thread(() -> {
//            int counter = 0;
//            while (counter++ < 8)
//                queue.remove();
//        }, "consumer").start();
//
//        System.out.println(queue);

// -SYNCHRONIZATION-END-------------------------------------------------------------------------------------------------
// -THREAD-TRANSITIONS--------------------------------------------------------------------------------------------------

        Thread thread4 = new Thread(() -> {
            try {
                Thread.sleep(1);
                for (int i = 0; i < 100; i++);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
//        thread4.start();
//        while (thread4.getState() != Thread.State.TERMINATED) {
//            System.out.println(thread4.getState());
//        }

//        try {
//            thread4.join(); // this thread executes first and then the main thread executes.
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

// -DEADLOCK------------------------------------------------------------------------------------------------------------

        String lock1 = "1";
        String lock2 = "2";

//        new Thread(() -> {
//            synchronized (lock1) {
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                System.out.println("Thread 5 acquired lock 1");
//                synchronized (lock2) {
//                    System.out.println("Thread 5 acquired lock 2");
//                }
//            }
//        }, "Thread5").start();
//
//        new Thread(() -> {
//            synchronized (lock2) {
//                System.out.println("Thread 6 acquired lock 2");
//                synchronized (lock1) {
//                    System.out.println("Thread 6 acquired lock 1");
//                }
//            }
//        }, "Thread6").start();
//
//        System.out.println("\n---- " + LearnThreads.class.getName() + " ending ----\n");


        int noOfCores  = Runtime.getRuntime().availableProcessors();
        System.out.println("no of cores " + noOfCores);
        ExecutorService executorService = Executors.newFixedThreadPool(noOfCores);


        for (int i = 0; i < 100; i++) {
            Future<Integer> val = executorService.submit(new CallableClass(i));
            System.out.println(val.get());
        }


    }
}







