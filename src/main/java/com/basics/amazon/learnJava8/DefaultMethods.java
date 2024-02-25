package com.basics.amazon.learnJava8;


interface A {
    default void show() { System.out.println("Hello"); }
    void print();
}

public class DefaultMethods {
    public static void main(String[] args) {
        A a = () -> System.out.println("printing"); // implementing Anonymous class and overriding method
        a.show();
        a.print();
    }
}
