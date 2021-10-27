package com.example.practice.pattern.structural.decorator.bianshen;

import com.example.practice.pattern.structural.decorator.bianshen.component.Morrigan;
import com.example.practice.pattern.structural.decorator.bianshen.component.Original;
import com.example.practice.pattern.structural.decorator.bianshen.decorator.Changer;
import com.example.practice.pattern.structural.decorator.bianshen.decorator.Girl;
import com.example.practice.pattern.structural.decorator.bianshen.decorator.Succubus;

/**
 * Morrigan / Component 抽象构件（接口）
 * Original / ConcreteComponent 具体构件/主体（实现 抽象构件）
 * Changer / Decorator 抽象装饰（实现 抽象构件、包含 具体构件/主体）
 * Girl & Succubus / ConcreteDecorator 具体装饰
 */
public class BianshenTest {
    public static void main(String[] args) {
        Morrigan morrigan = new Original();
        morrigan.display();

        Changer girl = new Girl(morrigan);
        girl.display();

        Changer succubus = new Succubus(morrigan);
        succubus.display();
    }
}
