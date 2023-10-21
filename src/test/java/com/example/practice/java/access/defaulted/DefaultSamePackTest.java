package com.example.practice.java.access.defaulted;

import com.example.practice.java.access.protect.ExtendProtectBase;

public class DefaultSamePackTest {
    public static void main(String[] args) {
        // 通过类访问
        String str1 = DefaultBase.defaultStaticStr;
        // 通过对象访问
        DefaultBase defaultBase = new DefaultBase();
        String str3 = defaultBase.defaultStaticStr;

        // 内部拓展
        // 通过类访问
//        String str11 = ExtendDefaultBase.protectedStaticStr; // 报错
        // 通过对象访问
        ExtendProtectBase extendProtectBase = new ExtendProtectBase();
//        String str12 = extendProtectBase.protectedStaticStr; // 报错

        // 内部拓展2
        // 通过类访问
//        String str21 = ExtendExtendDefaultBase.protectedStaticStr; // 报错
        // 通过对象访问
        ExtendExtendDefaultBase extendExtendDefaultBase = new ExtendExtendDefaultBase();
//        String str22 = extendExtendDefaultBase.protectedStaticStr; // 报错

        // 外部拓展 无（因为Default不能传到外部去）
    }
}
