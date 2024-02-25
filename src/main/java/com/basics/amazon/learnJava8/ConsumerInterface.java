package com.basics.amazon.learnJava8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerInterface {

    /*
    Consumer is a functional interface with 1 abstract and 1 default method
     */

    static Consumer<Integer> consumer = new Consumer<Integer>() {
        @Override
        public void accept(Integer t) {
            System.out.println(t + 1);
        }
    };
    public static void main(String[] args) {
        System.out.println("With new consumer interface-------");
        List<Integer> arrList = Arrays.asList(1,2,3,4,5);
        arrList.forEach(consumer.andThen(consumer));

        System.out.println("With lambda expressions-----------");

        Consumer<Integer> c = System.out::println;
        Consumer<Integer> c2 = i -> System.out.println(i*i);
        arrList.forEach(c.andThen(c2));
    }
}
