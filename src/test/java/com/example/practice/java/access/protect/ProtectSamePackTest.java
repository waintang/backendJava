package com.example.practice.java.access.protect;

import com.example.practice.java.access.ExtendProtectDiffPackBase;

public class ProtectSamePackTest {

    public static void main(String[] args) {
        // 通过类访问
        String str1 = ProtectBase.protectedStaticStr;
        // 通过对象访问
        ProtectBase protectBase = new ProtectBase();
        String str2 = protectBase.protectedStaticStr;


        // 拓展
        // 通过类访问
        String str11 = ExtendProtectBase.protectedStaticStr;
        // 通过对象访问
        ExtendProtectBase extendProtectBase = new ExtendProtectBase();
        String str12 = extendProtectBase.protectedStaticStr;


        // 外包拓展
        // 通过类访问
        String str21 = ExtendProtectDiffPackBase.protectedStaticStr; // 报错
        // 通过对象访问
        ExtendProtectDiffPackBase extendProtectDiffPackBase = new ExtendProtectDiffPackBase();
        String str22 = extendProtectDiffPackBase.protectedStaticStr; // 报错
    }
}
