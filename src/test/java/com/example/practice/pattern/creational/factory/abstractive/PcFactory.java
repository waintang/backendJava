package com.example.practice.pattern.creational.factory.abstractive;

import com.example.practice.pattern.creational.factory.Keyboard;
import com.example.practice.pattern.creational.factory.Mouse;

public abstract class PcFactory {
    abstract Mouse createMouse();
    abstract Keyboard createKeyboard();

    public final void createPc(){
        Mouse mouse = createMouse();
        Keyboard keyboard = createKeyboard();
        System.out.print("已创建一台PC【使用鼠标：");
        mouse.leftClick();
        System.out.print("，使用键盘：");
        keyboard.print();
        System.out.println("】");
    }
}
