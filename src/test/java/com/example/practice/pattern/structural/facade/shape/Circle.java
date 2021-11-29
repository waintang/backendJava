package com.example.practice.pattern.structural.facade.shape;

// 子系统 1
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("画圆");
    }
}
