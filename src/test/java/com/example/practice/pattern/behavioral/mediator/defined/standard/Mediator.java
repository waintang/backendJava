package com.example.practice.pattern.behavioral.mediator.defined.standard;

public interface Mediator {
    public void register(Colleague colleague);
    //转发
    public void relay(Colleague colleague,String info);
}
