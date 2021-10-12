package com.example.practice.pattern.creational.factory.basic;

import com.example.practice.pattern.creational.factory.Mouse;

public class FactoryTest {
    public static void main(String[] args) {
        MouseFactory mouseFactory = new DellMouseFactory();
        Mouse mouse = mouseFactory.createMouse();
        mouse.leftClick();
    }
}
