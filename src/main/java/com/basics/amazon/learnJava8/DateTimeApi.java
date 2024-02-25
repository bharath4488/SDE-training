package com.basics.amazon.learnJava8;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;

public class DateTimeApi {
    /*
    Reason for new DateTime api:
        Java has 2 packages - java.util.date, java.sql.date
            util date optimized for machine.
            Sql date optimized for dbs.
        Have to use java.text.* to format date.
        Date package is not thread safe.

        DateTime is immutable, throws exception on 29th feb not leap year.
     */

    public static void main(String[] args) {
        LocalDate d = LocalDate.now();
        System.out.println(d); // 2024-02-25
        LocalDate d2 = LocalDate.of(1908, Month.JANUARY, 06);
        System.out.println(d2); // 1908-01-06

        LocalTime t = LocalTime.now();
        System.out.println(t); // 20:36:07.762188500

        ZoneId.getAvailableZoneIds()
                .forEach(x -> System.out.println(x + " - " + LocalTime.now(ZoneId.of(x))));
    }



}
