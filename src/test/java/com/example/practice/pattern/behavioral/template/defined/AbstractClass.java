package com.example.practice.pattern.behavioral.template.defined;

public abstract class AbstractClass {
    public void templateMethod(){
        specificMethod();
        specificMethod1();
        specificMethod2();
    }

    public void specificMethod(){
        System.out.println("模板模式-公用方法");
    }

    protected abstract void specificMethod1();

    protected abstract void specificMethod2();

}
