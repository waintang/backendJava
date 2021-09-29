package com.example.practice.pattern.creational.factory.abstractive;

import com.example.practice.pattern.creational.factory.Keyboard;
import com.example.practice.pattern.creational.factory.Mouse;
import com.example.practice.pattern.creational.factory.basic.HpMouseFactory;

public class HpPcFactory extends PcFactory {
    @Override
    public Mouse createMouse() {
        return new HpMouseFactory().createMouse();
    }

    @Override
    public Keyboard createKeyboard() {
        return new HpKeyboardFactory().createKeyboard();
    }
}
