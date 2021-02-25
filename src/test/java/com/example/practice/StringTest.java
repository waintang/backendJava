package com.example.practice;
public class StringTest {
    public static void main(String[] args) {
        System.out.println("***************************测试String7前后intern差异");
        String h1=new String("22")+new String("1");//堆 22、1、221，堆-常量池：（jdk6时,22、1两字符串；jdk7时,堆22、1串的引用）
        h1.intern();// 堆221添加给 常量池：（jdk6时，221字符串给常量池；jdk7时，堆221串的引用给常量池）
        String h2="221"; // 此时，常量池有221，于是：h2（jdk6指向常量池221字符串的引用，jdk7借由常量池指向堆221字符串的引用 ）

        System.out.println("h1和h2 引用地址是否相同："+(h1 == h2));//result：jdk6 false；jdk7 true
        System.out.println("h1和h2 值是否相同："+h1.equals(h2));//result：true
        System.out.println("***************************");
    }
}
