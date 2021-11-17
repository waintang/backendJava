package com.example.practice.java8.thread;

public class ThreadTest {
    static ThreadLocal<String> localStr =  new ThreadLocal<>();
    public static void main(String[] args){

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                localStr.set("twp");
                System.out.println(localStr.get());
            }
        });
        thread1.start();
    }
}
