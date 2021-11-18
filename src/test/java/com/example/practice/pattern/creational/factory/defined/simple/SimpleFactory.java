package com.example.practice.pattern.creational.factory.defined.simple;

public class SimpleFactory {
    public static Product creteProduct(int productFlag){
        switch (productFlag){
            case Const.PRODUCT_B:
                return new ConcreteProductB();
            default:
                return new ConcreteProductA();
        }
    }
}
