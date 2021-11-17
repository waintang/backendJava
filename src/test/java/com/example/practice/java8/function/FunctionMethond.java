package com.example.practice.java8.function;

public interface FunctionMethond {
    void testInterface();

    default void testDefault(){
        System.out.println("interface default method.");
    }

    static void testStatic(){
        System.out.println("interface static method.");
    }
}
