package com.example.practice.pattern.creational.factory.simple;

import com.example.practice.pattern.creational.factory.DellMouse;
import com.example.practice.pattern.creational.factory.HpMouse;
import com.example.practice.pattern.creational.factory.Mouse;

public class MouseFactory {

    /**
     * @param brand 不同品牌
     * @return
     */
    public static Mouse createMouse(int brand){
        Mouse mouse = null;
        switch(brand){
            case 1:
                mouse = new DellMouse();
                break;
            case 2:
                mouse = new HpMouse();
                break;
            default:
                throw new RuntimeException("此工厂暂不代工此品牌鼠标");
        }
        return mouse ;
    }

}
