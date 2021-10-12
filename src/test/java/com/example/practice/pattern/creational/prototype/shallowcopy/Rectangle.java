package com.example.practice.pattern.creational.prototype.shallowcopy;

public class Rectangle extends Shape {

    public Rectangle(){
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("Rectangle draw()");
    }
}
