package com.example.practice.pattern.creational.singleton.lazy;

/**
 * 三、懒汉模式 - 双检锁 同步锁 类class文件
 * 线程 安全
 * 性能 高
 *
 * Lazy初始化：懒汉模式 都是Lazy延迟初始化
 */
public class LazyDoubleCheck {
    // 多线程 双检锁 时，保证可见性/禁止重排序
    private static volatile LazyDoubleCheck instance;

    private LazyDoubleCheck(){

    }

    public static LazyDoubleCheck getInstance(){
        if(instance == null){
            synchronized (LazyDoubleCheck.class){
                if(instance == null){
                    instance = new LazyDoubleCheck();
                }
            }
        }
        return instance;
    }

    public void print(){
        System.out.println("LazyDoubleCheck::print");
    }
}
