package com.example.practice.pattern.creational.singleton.lazy;

public class LazyDoubleCheckTest {
    public static void main(String[] args) {
        LazyDoubleCheck lazyDoubleCheck = LazyDoubleCheck.getInstance();
        lazyDoubleCheck.print();
    }
}
