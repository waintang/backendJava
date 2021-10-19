package com.example.practice.pattern.structural.bridge.defined;

/**
 * 拓展抽象化角色
 */
public class RefinedAbstraction extends Abstraction {

    public RefinedAbstraction(Implementor implementor){
        super(implementor);
    }
    @Override
    public void operation() {
        impl.OperationImpl();
    }
}
