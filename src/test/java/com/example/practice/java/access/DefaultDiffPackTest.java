package com.example.practice.java.access;

import com.example.practice.java.access.defaulted.DefaultBase;
import com.example.practice.java.access.defaulted.ExtendDefaultBase;

public class DefaultDiffPackTest {
    public static void main(String[] args) {
        // 通过类访问
//        String str1 = DefaultBase.defaultStaticStr; // 报错
        // 通过对象访问
        DefaultBase defaultBase = new DefaultBase();
//        String str2 = defaultBase.defaultStaticStr; // 报错

        // 同包拓展
        ExtendDefaultBase extendDefaultBase = new ExtendDefaultBase();
//        String str11 = extendDefaultBase.extendDefaultBase;  // 报错

        // 外包拓展 无（default都传不到外包来，更别提 外包的”同包亲戚类“）
//        String str21 = ExtendDefaultDiffPackBase.defaultStaticStr; // 报错
        // 通过对象访问
        ExtendDefaultDiffPackBase extendDefaultDiffPackBase = new ExtendDefaultDiffPackBase();
//        String str22 = extendDefaultDiffPackBase.defaultStaticStr; // 报错
    }
}
