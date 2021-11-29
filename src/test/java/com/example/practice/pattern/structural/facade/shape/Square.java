package com.example.practice.pattern.structural.facade.shape;

// 子系统 3
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("画方型");
    }
}
