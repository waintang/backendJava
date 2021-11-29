package com.example.practice.pattern.structural.flyweight.defined;

public class DefinedTest {
    public static void main(String[] args) {
        FlyweightFactory flyweightFactory =new FlyweightFactory();
        Flyweight flyweight1 = flyweightFactory.getFlyweight("a");
        Flyweight flyweight2 = flyweightFactory.getFlyweight("a");
        Flyweight flyweight3 = flyweightFactory.getFlyweight("b");
        Flyweight flyweight4 = flyweightFactory.getFlyweight("b");
        flyweight1.operation(new UnsharedConcreteFlywight("第一次调用a"));
        flyweight2.operation(new UnsharedConcreteFlywight("第二次调用a"));
        flyweight3.operation(new UnsharedConcreteFlywight("第一次调用b"));
        flyweight4.operation(new UnsharedConcreteFlywight("第二次调用b"));
    }
}
