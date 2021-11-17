package com.example.practice.java8.function;

import org.springframework.util.ObjectUtils;

import java.util.function.Function;

/**
 * Function的compose、andThen、identity、apply应用
 */
public class FunctionTest {
    public static void main(String[] args) {
        String a = null;///"abc";
        boolean flag = !ObjectUtils.isEmpty(a)&&a.contains("aabc");
        System.out.println(flag);
        FunctionMethond functionMethond = new FunctionMethond(){
            @Override
            public void testInterface() {
                System.out.println("interface interface method.");
            }
        };
        FunctionMethond.testStatic();
        functionMethond.testDefault();
        functionMethond.testInterface();
    }
}
