package com.example.practice.pattern.creational.prototype.shallowcopy;

import java.util.Hashtable;

public class ShapeCache {

    private static Hashtable<Long,Shape> shapeMap = new Hashtable<Long,Shape>();

    public static Shape getShape(long shapeId){
        Shape cachedShape = shapeMap.get(shapeId);
        return (Shape)cachedShape.clone();
    }

    public static void loadCache(){
        Circle circle = new Circle();
        circle.setId(1L);
        shapeMap.put(circle.getId(),circle);

        Square square = new Square();
        square.setId(2L);
        shapeMap.put(square.getId(),square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId(3L);
        shapeMap.put(rectangle.getId(),rectangle);

    }

}
