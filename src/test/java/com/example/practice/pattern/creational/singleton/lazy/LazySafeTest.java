package com.example.practice.pattern.creational.singleton.lazy;

public class LazySafeTest {
    public static void main(String[] args) {
        LazySafe lazySafe = LazySafe.getInstance();
        lazySafe.print();
    }
}
