package com.example.practice.java.access;

import com.example.practice.java.access.protect.ExtendProtectBase;
import com.example.practice.java.access.protect.ProtectBase;

public class ProtectDiffPackTest {

    public static void main(String[] args) {
        // 通过类访问
//        String str1 = ProtectBase.protectedStaticStr; // 报错
        // 通过对象访问
        ProtectBase protectBase = new ProtectBase();
//        String str2 = protectBase.protectedStaticStr; // 报错

        // 内包拓展
        // 通过类访问
//        String str11 = ExtendProtectBase.protectedStaticStr; // 报错
        // 通过对象访问
        ExtendProtectBase extendProtectBase = new ExtendProtectBase();
//        String str12 = extendProtectBase.protectedStaticStr; // 报错

        // 外包拓展
        // 通过类访问
//        String str21 = ExtendProtectDiffPackBase.protectedStaticStr; // 报错
        // 通过对象访问
        ExtendProtectDiffPackBase extendProtectDiffPackBase = new ExtendProtectDiffPackBase();
//        String str22 = extendProtectDiffPackBase.protectedStaticStr; // 报错
    }
}
