package com.example.practice.pattern.behavioral.responsibilitychain.defined;

public class ClientTest {
    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        handler1.setNextHandler(handler2);
        handler1.handleRequest("one1");
    }
}
