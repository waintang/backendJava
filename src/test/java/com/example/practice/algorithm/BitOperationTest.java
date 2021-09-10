package com.example.practice.algorithm;

public class BitOperationTest {

    /**
     * 位运算
     * 左移( << )、右移( >> ) 、无符号右移( >>> ) 、位与( & ) 、位或( | )、位非( ~ )、位异或( ^ )
     * @param args
     */
    // 参考链接：https://blog.csdn.net/xiaochunyong/article/details/7748713      Java 位运算(移位、位与、或、异或、非）
    public static void main(String[] args) {
        Integer a = -8;
        // 二进制
        System.out.println( Integer.toBinaryString(a));
        System.out.println(~a);
        System.out.println(Integer.toBinaryString(~a));
    }
}
