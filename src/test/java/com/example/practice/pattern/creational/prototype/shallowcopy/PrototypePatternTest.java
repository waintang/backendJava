package com.example.practice.pattern.creational.prototype.shallowcopy;

/**
 * 此处 仍为深克隆
 */
public class PrototypePatternTest {
    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape clonedShape = ShapeCache.getShape(1L);
        System.out.println("Shape:"+clonedShape.getType());
        Shape clonedShapeBak = ShapeCache.getShape(1L);
        System.out.println("Shape==ShapeClone:"+(clonedShape==clonedShapeBak));

        Shape clonedShape2 = ShapeCache.getShape(2L);
        System.out.println("Shape:"+clonedShape2.getType());

        Shape clonedShape3 = ShapeCache.getShape(3L);
        System.out.println("Shape:"+clonedShape3.getType());

    }
}
