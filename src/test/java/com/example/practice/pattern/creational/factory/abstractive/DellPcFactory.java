package com.example.practice.pattern.creational.factory.abstractive;

import com.example.practice.pattern.creational.factory.DellKeyboard;
import com.example.practice.pattern.creational.factory.Keyboard;
import com.example.practice.pattern.creational.factory.Mouse;
import com.example.practice.pattern.creational.factory.basic.DellMouseFactory;

public class DellPcFactory extends PcFactory {
    @Override
    public Mouse createMouse() {
        return new DellMouseFactory().createMouse();
    }

    @Override
    public Keyboard createKeyboard() {
        return new DellKeyboardFactory().createKeyboard();
    }
}
