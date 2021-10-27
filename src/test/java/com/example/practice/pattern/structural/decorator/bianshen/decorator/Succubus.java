package com.example.practice.pattern.structural.decorator.bianshen.decorator;

import com.example.practice.pattern.structural.decorator.bianshen.component.Morrigan;

/**
 * 具体装饰类
 */
public class Succubus extends Changer {
    public Succubus(Morrigan morrigan) {
        super(morrigan);
    }

    @Override
    public void display() {
        super.display();
        succubusDecorate();
    }

    private void succubusDecorate(){
        System.out.println("变身女妖");
    }
}
