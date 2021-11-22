package com.example.practice.pattern.behavioral.mediator.estate;

public interface Mediator {
    void register(Customer member);
    void relay(String name,String info);
}
