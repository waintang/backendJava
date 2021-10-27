package com.example.practice.pattern.behavioral.template.defined;

public class ConcreteClass extends AbstractClass {
    @Override
    protected void specificMethod1() {
        System.out.println("抽象方法1被实现了");
    }

    @Override
    protected void specificMethod2() {
        System.out.println("抽象方法2被实现了");
    }
}
