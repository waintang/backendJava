package com.example.practice.pattern.structural.facade.shape;

// 子系统 2
public class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("画长方形");
    }
}
