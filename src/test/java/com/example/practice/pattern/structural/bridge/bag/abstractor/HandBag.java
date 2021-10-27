package com.example.practice.pattern.structural.bridge.bag.abstractor;

import com.example.practice.pattern.structural.bridge.bag.impl.Color;

public class HandBag extends Bag {

    public HandBag(Color color){
        super(color);
    }

    @Override
    public String getName() {
        return "手提包，颜色："+color.getColor();
    }
}
