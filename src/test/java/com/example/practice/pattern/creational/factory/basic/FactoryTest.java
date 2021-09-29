package com.example.practice.pattern.creational.factory.basic;

public class FactoryTest {
    public static void main(String[] args) {
        MouseFactory mouseFactory = new DellMouseFactory();
        mouseFactory.createMouse();
    }
}
