package com.example.practice.pattern.structural.decorator.bianshen.decorator;

import com.example.practice.pattern.structural.decorator.bianshen.component.Morrigan;

/**
 * 具体装饰器
 */
public class Girl extends Changer {
    public Girl(Morrigan morrigan) {
        super(morrigan);
    }

    @Override
    public void display() {
        super.display();
        girlDecorate();
    }

    private void girlDecorate(){
        System.out.println("变身少女");
    }
}
