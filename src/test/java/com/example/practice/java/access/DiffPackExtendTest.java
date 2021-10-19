package com.example.practice.java.access;

public class DiffPackExtendTest {
    public static void main(String[] args) {
        ExtendProtectBase extendProtectBase = new ExtendProtectBase();
//        extendProtectBase.protectedStaticStr;
        System.out.println(extendProtectBase.test());

        ExtendDefaultBase extendDefaultBase = new ExtendDefaultBase();
//        String a=  extendDefaultBase.defaultStaticStr;
        System.out.println(extendDefaultBase.test());
    }
}
