package com.example.practice.pattern.creational.factory.simple;

import com.example.practice.pattern.creational.factory.Mouse;

public class SimpleFactoryTest {

    public static void main(String[] args) {
        Mouse mouse = MouseFactory.createMouse(1);
        mouse.leftClick();
    }

}
