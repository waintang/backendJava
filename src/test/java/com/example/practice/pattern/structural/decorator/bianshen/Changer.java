package com.example.practice.pattern.structural.decorator.bianshen;

/**
 * 抽象装饰器（此处 用的是 类，不是抽象类）
 */
public class Changer implements Morrigan {

    private Morrigan morrigan ;

    public Changer(Morrigan morrigan){
        this.morrigan = morrigan;
    }

    @Override
    public void display() {
        morrigan.display();
    }
}
