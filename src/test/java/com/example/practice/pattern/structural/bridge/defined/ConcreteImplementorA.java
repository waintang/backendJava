package com.example.practice.pattern.structural.bridge.defined;

public class ConcreteImplementorA implements Implementor {
    @Override
    public void OperationImpl() {
        System.out.println("具体实现化角色A  实现业务逻辑");
    }
}
