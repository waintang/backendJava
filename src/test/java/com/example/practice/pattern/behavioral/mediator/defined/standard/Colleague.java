package com.example.practice.pattern.behavioral.mediator.defined.standard;

public abstract class Colleague {
    protected Mediator mediator;
    public void setMediator(Mediator mediator){
        this.mediator = mediator;
    }
    public abstract void send(String info);

    public abstract void receive(String info);
}
