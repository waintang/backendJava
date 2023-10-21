package com.example.practice.java.access;

import com.example.practice.java.access.protect.ProtectBase;

public class ExtendProtectDiffPackBase extends ProtectBase {
    // protect+不同包+类/集成方式 场景：不能访问
    {
         String str = protectedStaticStr;
    }
    String test(){
        return protectedStaticStr;
    }
}
