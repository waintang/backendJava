package com.example.practice;

public class Main {
    public static void main(String[] args) {
//        String h1=new String("22")+new String("1");//堆 22、1、221，堆-常量池：（jdk6时,22、1两字符串；jdk7时,堆22、1串的引用）
//        h1.intern();// 堆221添加给 常量池：（jdk6时，221字符串给常量池；jdk7时，堆221串的引用给常量池）
//        String h2="221"; // 此时，常量池有221，于是：h2（jdk6指向常量池221字符串的引用，jdk7借由常量池指向堆221字符串的引用 ）
//
//        System.out.println("h1和h2 引用地址是否相同："+(h1 == h2));//result：jdk6 false；jdk7 true
//        System.out.println("h1和h2 值是否相同："+h1.equals(h2));//result：true
//
//        boolean test = "a"==null;
//        System.out.println("test:"+test);


        Thread t = new Thread(){
            @Override
            public void run(){
                try {
                    Thread.sleep(1000L);
                    System.out.println(System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                pong();
            }
        };
        t.run();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis());
        System.out.println("ping");

    }
    static void pong(){
        System.out.println("pong");
    };
}
