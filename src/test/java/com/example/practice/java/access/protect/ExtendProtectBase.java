package com.example.practice.java.access.protect;

public class ExtendProtectBase extends ProtectBase {
    String test(){
        return protectedStaticStr;
    }
}
