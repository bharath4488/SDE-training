package com.basics.amazon.learnJava8;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Predicates {
    public static void main(String[] args) {
        List<String> times =
                ZoneId.getAvailableZoneIds()
                        .stream()
                        .map(x -> x + " " + LocalTime.now(ZoneId.of(x)))
                        .filter(x -> x.startsWith("Asia")) // filter takes a predicate, evaluates to boolean
                        .collect(Collectors.toList());

        System.out.println(times);
    }
}
