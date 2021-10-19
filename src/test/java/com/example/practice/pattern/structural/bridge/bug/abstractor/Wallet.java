package com.example.practice.pattern.structural.bridge.bug.abstractor;

import com.example.practice.pattern.structural.bridge.bug.impl.Color;

public class Wallet extends Bag {

    public Wallet(Color color){
        super(color);
    }

    @Override
    String getName() {
        return "手包，颜色："+color.getColor();
    }
}
