package com.example.practice.pattern.creational.factory.basic;

import com.example.practice.pattern.creational.factory.HpMouse;
import com.example.practice.pattern.creational.factory.Mouse;

public class HpMouseFactory implements MouseFactory {
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }
}
