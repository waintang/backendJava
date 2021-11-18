package com.example.practice.pattern.creational.factory.defined.factory;

import com.example.practice.pattern.creational.factory.defined.factory.AbstractFactory;
import com.example.practice.pattern.creational.factory.defined.factory.ConcreteProductA;
import com.example.practice.pattern.creational.factory.defined.factory.Product;

public class ConcreteFactory implements AbstractFactory {
    @Override
    public Product createProduct() {
        return new ConcreteProductA();
    }
}
