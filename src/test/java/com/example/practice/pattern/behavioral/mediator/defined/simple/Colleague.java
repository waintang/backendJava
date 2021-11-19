package com.example.practice.pattern.behavioral.mediator.defined.simple;

import com.example.practice.pattern.behavioral.mediator.defined.standard.Mediator;

public abstract class Colleague {
    protected SimpleMediator mediator;

    public abstract void send(String info);

    public abstract void receive(String info);
}
