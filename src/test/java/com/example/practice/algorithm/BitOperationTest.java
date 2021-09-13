package com.example.practice.algorithm;

import java.util.HashMap;
import java.util.Map;

public class BitOperationTest {

    /**
     * 位运算
     * 左移( << )、右移( >> ) 、无符号右移( >>> ) 、位与( & ) 、位或( | )、位非( ~ )、位异或( ^ )
     * @param args
     */
    // 参考链接：https://blog.csdn.net/xiaochunyong/article/details/7748713      Java 位运算(移位、位与、或、异或、非）
    // 应用：hashmap的泊松分布、加载因子关系：https://blog.csdn.net/liji_xc/article/details/79698223  java集合框架分析-HashMap(加载因子及初始容量深入分析)
    public static void main(String[] args) {
        Integer a = 57;
        //左移
        System.out.println("将5左移2位:");
        System.out.println( Integer.toBinaryString(5));
        System.out.println( 5<<2);
        System.out.println( Integer.toBinaryString(5<<2));
        //右移
        System.out.println("将5右移2位:");
        System.out.println( Integer.toBinaryString(5));
        System.out.println( 5>>2);
        System.out.println( Integer.toBinaryString(5>>2));
        //无符号右移
        System.out.println("将-5无符号右移2位:");
        System.out.println( Integer.toBinaryString(-5));
        System.out.println( 5>>>2);
        System.out.println( Integer.toBinaryString(-5>>>2));

        // 与
        System.out.println("5&3:");
        System.out.println( Integer.toBinaryString(5));
        System.out.println( Integer.toBinaryString(3));
        System.out.println(5&3);
        // 或
        System.out.println("5|3:");
        System.out.println( Integer.toBinaryString(5));
        System.out.println( Integer.toBinaryString(3));
        System.out.println(5|3);
        // 非
        System.out.println("~5:");
        System.out.println( Integer.toBinaryString(5));
        System.out.println( Integer.toBinaryString(~5));
        // 异或
        System.out.println("5^3:");
        System.out.println( Integer.toBinaryString(5));
        System.out.println( Integer.toBinaryString(3));
        System.out.println(5^3);

        // 0  -1的二进制
        System.out.println("0:");
        System.out.println( Integer.toBinaryString(0));
        System.out.println("-1:");  //算法 ： 1原码的反码 + 1
        System.out.println( Integer.toBinaryString(-1));
    }
}
