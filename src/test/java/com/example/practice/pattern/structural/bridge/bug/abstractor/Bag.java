package com.example.practice.pattern.structural.bridge.bug.abstractor;

import com.example.practice.pattern.structural.bridge.bug.impl.Color;

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

    abstract String getName();

}
