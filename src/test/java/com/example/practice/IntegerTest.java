package com.example.practice;

import java.lang.reflect.Field;

public class IntegerTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        System.out.println("***************************测试-128至127是缓存： 2+2=5");
        Class cache = Integer.class.getDeclaredClasses()[0]; // Integer 内部类
        Field myCache = cache.getDeclaredField("cache"); // 内部类的 成员变量
        myCache.setAccessible(true);// 成员变量 让其可修改

        Integer[] newCache = (Integer[]) myCache.get(cache); //反射 拿到 静态内部类的 成员变量值
        newCache[132] = newCache[133]; // 第132位 是 132-128=4 ，133位是 133-128=5；值4的位置 指向 值5的指针
        int a = 2;
        int b = a + a;
        System.out.printf("%d + %d = %d", a, a, b); //
        System.out.println("");
        System.out.println("***************************");
    }
}
