package com.example.practice.pattern.behavioral.state.defined;

/**
 * 具体状态 A
 */
public class ConcreteStateA extends  State {
    @Override
    public void handle(Context context) {
        System.out.printf("切换到了状态A，立马切换到状态B。");
        context.setState(new ConcreteStateB());
    }
}
