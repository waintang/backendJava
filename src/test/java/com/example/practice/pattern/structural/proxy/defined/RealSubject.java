package com.example.practice.pattern.structural.proxy.defined;

public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("访问真实主题");
    }
}
