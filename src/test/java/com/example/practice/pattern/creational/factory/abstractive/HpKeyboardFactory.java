package com.example.practice.pattern.creational.factory.abstractive;

import com.example.practice.pattern.creational.factory.HpKeyboard;
import com.example.practice.pattern.creational.factory.Keyboard;

public class HpKeyboardFactory implements KeyboardFactory {
    @Override
    public Keyboard createKeyboard() {
        return new HpKeyboard();
    }
}
