package com.example.practice.pattern.behavioral.state.defined;

/**
 * 上下文环境角色 / 主体（拥有状态 并 初始化）
 */
public class Context {

    private State state;

    public Context(){
        state = new ConcreteStateA();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void handle(){
        state.handle(this);
    }
}
