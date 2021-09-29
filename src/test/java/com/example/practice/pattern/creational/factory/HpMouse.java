package com.example.practice.pattern.creational.factory;

public class HpMouse implements Mouse {
    @Override
    public void leftClick() {
        System.out.println("左键：惠普鼠标");
    }
}
