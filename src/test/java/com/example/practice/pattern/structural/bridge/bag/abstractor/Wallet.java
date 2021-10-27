package com.example.practice.pattern.structural.bridge.bag.abstractor;

import com.example.practice.pattern.structural.bridge.bag.impl.Color;

public class Wallet extends Bag {

    public Wallet(Color color){
        super(color);
    }

    @Override
    public String getName() {
        return "手包，颜色："+color.getColor();
    }
}
