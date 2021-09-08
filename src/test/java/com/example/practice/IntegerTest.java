package com.example.practice;

import java.lang.reflect.Field;
import java.math.BigDecimal;

public class IntegerTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        System.out.println("*************************** == null");
        Long testLongValue = null;
        if(null == testLongValue){
            System.out.println("null == null is OK.");
        }
        try{
            if(-BigDecimal.ONE.longValue() == testLongValue){
                System.out.println("testLongValue null value is OK.");
            }
        }catch (Exception e){
            System.out.println("testLongValue null value is not OK.");
        }
        System.out.println("***************************");
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
        System.out.println("***************************测试int范围，超过： 2+2=5");
        int pageSize = 0;
        System.out.println(pageSize);
        pageSize = Integer.MAX_VALUE+Integer.MAX_VALUE;
        System.out.println(pageSize);
        System.out.println("***************************");
    }
}
