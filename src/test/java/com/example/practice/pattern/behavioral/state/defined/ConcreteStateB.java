package com.example.practice.pattern.behavioral.state.defined;

/**
 * 具体状态 B
 */
public class ConcreteStateB extends State {
    @Override
    public void handle(Context context) {
        System.out.printf("切换到了状态B，立马切换到状态A。");
        context.setState(new ConcreteStateA());
    }
}
