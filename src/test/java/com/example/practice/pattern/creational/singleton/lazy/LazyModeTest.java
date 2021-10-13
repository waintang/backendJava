package com.example.practice.pattern.creational.singleton.lazy;

public class LazyModeTest {
    public static void main(String[] args) {
        LazyMode lazyMode = LazyMode.getInstance();
        lazyMode.print();
    }
}
