package com.example.practice.pattern.creational.factory.defined.factory;

public class FactoryDefinedTest {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = new ConcreteFactory();
        Product product = abstractFactory.createProduct();
        product.show();
    }
}
