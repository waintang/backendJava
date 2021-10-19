package com.example.practice.java.access.defaulted;

public class Other {
    String a = DefaultBase.defaultStaticStr;
    DefaultBase defaultBase = new DefaultBase();

    void test(){
        a = defaultBase.defaultInstanceStr;
    }
}
