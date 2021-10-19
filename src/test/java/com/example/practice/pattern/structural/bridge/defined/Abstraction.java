package com.example.practice.pattern.structural.bridge.defined;

/**
 * 抽象化角色
 */
public abstract class Abstraction {
    protected  Implementor impl;

    public Abstraction(Implementor impl){
        this.impl = impl;
    }

    public abstract void operation();

}
