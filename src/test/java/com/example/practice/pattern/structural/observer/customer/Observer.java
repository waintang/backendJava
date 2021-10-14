package com.example.practice.pattern.structural.observer.customer;

public abstract class Observer {

    protected Subject subject;

    public abstract  void update(Object object);

}
