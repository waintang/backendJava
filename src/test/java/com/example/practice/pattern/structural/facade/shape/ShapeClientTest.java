package com.example.practice.pattern.structural.facade.shape;

// 客户角色
public class ShapeClientTest {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.drawCircle();
        shapeMaker.drawSquare();
        shapeMaker.drawRectangle();
    }
}
