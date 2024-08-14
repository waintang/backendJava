package com.example.practice;

public class FinallyTest {
    /*
    测试finally没catch
    */
    public static void main(String[] args) {
        try {
            System.out.println("try一");
            throw new RuntimeException("抛出异常");
//            System.out.println("thorw 后");
        }finally {
            System.out.println("finally一");
        }
    }
}
