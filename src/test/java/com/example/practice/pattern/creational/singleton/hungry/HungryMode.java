package com.example.practice.pattern.creational.singleton.hungry;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 四、饿汉模式 - 普通
 * 线程 安全（靠 classLoader机制保证）
 * 性能 。。。
 *
 * Lazy初始化：饿汉模式 除 登记式-内部静态类方式 外，都是 非 延迟初始化
 */
public class HungryMode implements Serializable {
    private static HungryMode instance = new HungryMode();

    private HungryMode(){}

    public static  HungryMode getInstance(){
        return instance;
    }

    public void print(){
        System.out.println("HungryMode::print");
    }

    //反序列化定义该方法，则不需要创建新对象
    private Object readResolve() throws ObjectStreamException {
        return instance;
    }

}
