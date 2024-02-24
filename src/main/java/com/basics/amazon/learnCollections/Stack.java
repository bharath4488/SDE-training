package com.basics.amazon.learnCollections;

public class Stack {

    private int[] array;
    private int stackTop;

    private final Object lock; // for thread synchronization

    public Stack(int capacity) {
        this.array = new int[capacity];
        this.stackTop = -1;
        lock = new Object();
    }

    public boolean isEmpty() {
        return stackTop < 0;
    }

    public boolean isFull() {
        return stackTop == array.length - 1;
    }

    public /*synchronized*/ boolean push(int value) {
        synchronized (lock) {
            /*
            thread enters this method only when the lock is released by previous thread.
            since 2 synchronized blocks share same lock,
            no 2 threads can operate inside these synchronized methods simultaneously.
            public synchronized boolean push(int value) { ... } will make the whole method synchronized
             */
            if (isFull()) return false;
            ++stackTop;

            // used for LearnThreads.class
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

            array[stackTop] = value;
            return true;
        }
    }

    public int pop() {
        synchronized (lock) {
            if(isEmpty()) return -1;
            int top = array[stackTop];

            // used for LearnThreads.class
            try { Thread.sleep(1000); } catch (InterruptedException e) {}

            stackTop--;
            return top;
        }
    }

}
