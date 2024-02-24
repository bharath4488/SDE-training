package com.basics.amazon.learnDesignPatterns.creational;

public class SingletonPattern {

    /*
    Does not allow more than 1 object creation.
     */

    private static volatile SingletonPattern singletonInstance = null;
    /*
    Threads have their own cache,
    if one thread updates its value in its cache, another thread's cache remains the same.
    So to not let an object be stored in cache.
    Instead, to store the object in the main memory, volatile keyword is used.
    */

    private SingletonPattern() {
        // private constructor to avoid other class initializing this class
        System.out.println("Singleton Initiated...");
    }

    public static SingletonPattern getSingletonInstance() {
        if(singletonInstance == null) {
            singletonInstance = new SingletonPattern();
        }
        return singletonInstance;
    }

}
