package com.basics.amazon.learnJava8;

import java.util.function.Predicate;

@FunctionalInterface // error when 2 methods are declared
interface FuncInterface {
    void show();
}

public class FunctionalInterfaces {
    /*
    Functional interface has only one interface
     */
    public static void main(String[] args) {
        FuncInterface funcInterface = new FuncInterface() { // Anonymous inner class
            @Override
            public void show() {
                System.out.println("hello");
            }
        };
        // Anonymous class creation using Lambda expression
        FuncInterface funcInterface2 = () -> System.out.println("Hello");

        funcInterface.show();
        funcInterface2.show();

    }

}
