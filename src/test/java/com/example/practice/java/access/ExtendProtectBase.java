package com.example.practice.java.access;

import com.example.practice.java.access.protect.ProtectBase;

public class ExtendProtectBase extends ProtectBase {
    String test(){
        return protectedStaticStr;
    }
}
