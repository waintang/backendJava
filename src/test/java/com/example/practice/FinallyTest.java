package com.example.practice;

public class FinallyTest {
    public static void main(String[] args) {
        try {
            System.out.println("try一");
            System.out.println("try二");
            System.out.println("try3");
            throw new RuntimeException("抛出异常");
//            System.out.println("thorw 后");
        }finally {
            System.out.println("finally一");
        }
    }
}
