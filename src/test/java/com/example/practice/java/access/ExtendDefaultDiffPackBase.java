package com.example.practice.java.access;

import com.example.practice.java.access.defaulted.DefaultBase;

public class ExtendDefaultDiffPackBase extends DefaultBase {
    void test(){
        // default+不同包 场景：不能访问
//        String str = defaultStaticStr; // 报错
    }
}
