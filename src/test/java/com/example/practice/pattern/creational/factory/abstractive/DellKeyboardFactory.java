package com.example.practice.pattern.creational.factory.abstractive;

import com.example.practice.pattern.creational.factory.DellKeyboard;
import com.example.practice.pattern.creational.factory.Keyboard;

public class DellKeyboardFactory implements KeyboardFactory {
    @Override
    public Keyboard createKeyboard() {
        return new DellKeyboard();
    }
}
