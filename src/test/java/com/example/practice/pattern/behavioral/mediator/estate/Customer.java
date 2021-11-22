package com.example.practice.pattern.behavioral.mediator.estate;

public abstract class Customer {

    protected EstateMediator mediator;

    protected String name ;

    public abstract void send(String info);

    public abstract void receive(String from ,String info);

    public void setMediator(EstateMediator mediator) {
        this.mediator = mediator;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
