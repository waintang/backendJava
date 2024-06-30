package com.example.practice;

public class BooleanTest {
    public static void main(String[] args) {
        Boolean testBool = Boolean.TRUE.equals(null); // 返回false
        System.out.println(testBool);

        testBool = Boolean.valueOf("1"); // 返回false ；因为 只有Boolean.valueOf("true")是真，其它字符串都为假的
        System.out.println(testBool);
    }
}
