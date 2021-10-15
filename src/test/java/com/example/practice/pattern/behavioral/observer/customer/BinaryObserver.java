package com.example.practice.pattern.behavioral.observer.customer;

public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject){
        subject.addObserver(this);
    }

    @Override
    public void update(Object object) {
        if(object instanceof Subject){
            System.out.println("int to binary String :"+Integer.toBinaryString(((Subject) object).getState()));
        }
    }
}
