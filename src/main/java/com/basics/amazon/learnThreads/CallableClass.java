package com.basics.amazon.learnThreads;

import java.util.concurrent.Callable;

public class CallableClass implements Callable<Integer> {

    private final Integer number;

    CallableClass(Integer number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        return number * 2;
    }
}
