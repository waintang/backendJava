package com.example.practice.pattern.structural.observer.jdk;

import java.util.Observable;
import java.util.Observer;

public class BinaryObserver implements Observer {

    public BinaryObserver(Observable observable){
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof Subject){
            System.out.println("int to binary :"+ Integer.toBinaryString(((Subject) o).getState()));
        }
    }
}
