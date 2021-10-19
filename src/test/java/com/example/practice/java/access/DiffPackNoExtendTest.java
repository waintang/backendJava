package com.example.practice.java.access;

import com.example.practice.java.access.defaulted.DefaultBase;
import com.example.practice.java.access.privated.PrivateBase;
import com.example.practice.java.access.protect.ProtectBase;
import com.example.practice.java.access.publiced.PublicBase;

public class DiffPackNoExtendTest {
    public static void main(String[] args) {
        PublicBase publicBase = new PublicBase();
        String a = publicBase.publicInstanceStr;
        System.out.println(PublicBase.publicStaticStr);

        PrivateBase privateBase = new PrivateBase();
//        a = privateBase.privateInstanceStr;// compile err
//        System.out.println(PrivateBase.privateStaticStr);// compile err

        // default 除了村，自己都不能用了
        DefaultBase defaultBase = new DefaultBase();
//        a = defaultBase.defaultInstanceStr;// compile err
//        System.out.println(DefaultBase.defaultStaticStr);// compile err

        ProtectBase protectBase = new ProtectBase();
//        a = protectBase.protectedInstanceStr;// compile err
//        System.out.println(ProtectBase.protectedStaticStr);// compile err

    }
}
