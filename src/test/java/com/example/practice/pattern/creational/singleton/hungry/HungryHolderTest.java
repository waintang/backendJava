package com.example.practice.pattern.creational.singleton.hungry;

public class HungryHolderTest {
    public static void main(String[] args) {
        HungryHolder hungryHolder = HungryHolder.getInstance();
        hungryHolder.print();
    }
}
