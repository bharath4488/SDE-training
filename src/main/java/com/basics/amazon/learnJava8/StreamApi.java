package com.basics.amazon.learnJava8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi {

    public static void main(String[] args) {
        List<Integer> arrList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            arrList.add(i);
        }

        Stream stream  = arrList.stream();
        System.out.println(stream.map(StreamApi::print).collect(Collectors.toList()));
//        stream.filter(e -> (Integer)e%2 == 0).map(e -> (Integer)e + 1).forEach(StreamApi::print);
        System.out.println(stream.collect(Collectors.toList()));

    }

    public static int print(Object e) {
        return 1;
    }

}
