package com.example.practice.pattern.creational.singleton.lazy;

/**
 * 一、懒汉模式 - 普通
 * 线程 不安全
 * 性能 这里不考虑
 *
 * Lazy初始化：懒汉模式 都是Lazy延迟初始化
 */
public class LazyMode {
    private static LazyMode instance;

    private LazyMode(){

    }

    public static LazyMode getInstance(){
        if(instance == null){
            instance = new LazyMode();
        }
        return instance;
    }

    public void print(){
        System.out.println("LazyMode::print");
    }

}
