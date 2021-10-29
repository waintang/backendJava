package com.example.practice.pattern.structural.adapter.defined;

public class ObjectAdapter implements Target {

    private Adaptee adaptee ;

    public ObjectAdapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        System.out.println("对象适配器");
        adaptee.adapteeRequest();
    }
}
