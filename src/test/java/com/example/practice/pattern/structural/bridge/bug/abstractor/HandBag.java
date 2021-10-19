package com.example.practice.pattern.structural.bridge.bug.abstractor;

import com.example.practice.pattern.structural.bridge.bug.impl.Color;
import com.example.practice.pattern.structural.bridge.bug.impl.Red;

public class HandBag extends Bag {

    public HandBag(Color color){
        super(color);
    }

    @Override
    String getName() {
        return "手提包，颜色："+color.getColor();
    }
}
