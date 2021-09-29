package com.example.practice.pattern.creational.factory.abstractive;

import com.example.practice.pattern.creational.factory.Keyboard;
import com.example.practice.pattern.creational.factory.Mouse;
import com.example.practice.pattern.creational.factory.basic.DellMouseFactory;

/**
 * 自组装的PC（比如，我看好 Dell 的鼠标、HP 的键盘）
 */
public class SelfAssemblyPcFactory extends PcFactory {
    @Override
    public Mouse createMouse() {
        return new DellMouseFactory().createMouse();
    }

    @Override
    public Keyboard createKeyboard() {
        return new HpKeyboardFactory().createKeyboard();
    }
}
