package com.example.practice.pattern.behavioral.observer.customer;

public abstract class Observer {

    protected Subject subject;

    public abstract  void update(Object object);

}
