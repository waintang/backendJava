package com.example.practice.pattern.creational.prototype.shallowcopy;

public class Square extends Shape {

    public Square(){
        type = "Square";
    }

    @Override
    void draw() {
        System.out.println("Square.draw()");
    }
}
