package com.example.practice.pattern.structural.bridge.bag.abstractor;

import com.example.practice.pattern.structural.bridge.bag.impl.Color;

public abstract class Bag {
    protected Color color;

    public Bag(Color color){
        this.color = color;
    }

    void setColor(Color color){
        this.color = color;
    }

    protected  Color getColor(){
        return color;
    }

    public abstract String getName();

}
