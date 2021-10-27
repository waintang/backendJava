package com.example.practice.pattern.structural.decorator.defined;

/**
 * 抽象构件  抽象/接口
 * 具体构件  类
 * 抽象装饰器  抽象/类
 * 具体装饰器  类
 */
public class DefinedTest {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        component.operation();
        Decorator decorator = new ConcreteDecorator(component);
        decorator.operation();
    }
}
