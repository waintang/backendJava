package com.example.practice.pattern.creational.singleton.hungry;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class HungryEnumTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        HungryEnum hungryEnum = HungryEnum.getInstance();
//        HungryEnum hungryEnum = HungryEnum.SingletonEnum.INSTANCE.getInstance();
        hungryEnum.print();

        //测试  饿汉-枚举反射破解
        Constructor<HungryEnum> constructor = HungryEnum.class.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        HungryEnum hungryEnum1 = constructor.newInstance();
        System.out.println(hungryEnum1 == hungryEnum);
    }
}
