package com.example.practice.pattern.structural.decorator.defined;

/**
 * 抽象/接口 构件
 * 具体构件
 * 抽象/类 装饰器
 * 具体装饰器
 */
public class DefinedTest {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        component.operation();
        Decorator decorator = new ConcreteDecorator(component);
        decorator.operation();
    }
}
