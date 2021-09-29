package com.example.practice.pattern.creational.factory.basic;

import com.example.practice.pattern.creational.factory.DellMouse;
import com.example.practice.pattern.creational.factory.Mouse;

public class DellMouseFactory implements MouseFactory {
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }
}
