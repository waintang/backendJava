package com.example.practice.pattern.creational.singleton.lazy;

/**
 * 二、懒汉模式 - 同步锁 方法
 * 线程 安全
 * 性能 低
 *
 * Lazy初始化：懒汉模式 都是Lazy延迟初始化
 */
public class LazySafe {
    private static LazySafe instance;

    private LazySafe(){

    }

    public static synchronized LazySafe getInstance(){
        if(instance == null){
            instance = new LazySafe();
        }
        return instance;
    }

    public void print(){
        System.out.println("LazySafe::print");
    }
}
