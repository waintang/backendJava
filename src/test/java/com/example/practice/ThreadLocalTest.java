package com.example.practice;

public class ThreadLocalTest {
    private static final ThreadLocal<String> threadLocalStr = ThreadLocal.withInitial(()->"TWP");
    public static void main(String[] args) {
        String result = threadLocalStr.get();
        System.out.println("result:"+result); // result:TWP
        threadLocalStr.set("TWP2");
        String result2 = threadLocalStr.get();
        System.out.println("result2:"+result2); // result2:TWP2
        threadLocalStr.remove();
        String result3 = threadLocalStr.get();
        System.out.println("result3:"+result3); // result3:TWP
    }
}
