package com.example.practice.pattern.creational.singleton.hungry;

/**
 * 五、饿汉模式 - 登记式  内部静态类 登记
 * 线程 安全（靠 classLoader机制保证）
 * 性能 。。。
 *
 * Lazy初始化：饿汉模式 除 登记式-内部静态类方式 外，都是 非 延迟初始化
 */
public class HungryHolder {
    // 内部静态类 封装 单例对象
    private static class SingletonHolder{
        private static final HungryHolder instance = new HungryHolder();
    }

    private HungryHolder(){}

    public static HungryHolder getInstance(){
        return SingletonHolder.instance;
    }

    public void print(){
        System.out.println("HungryHolder::print");
    }
}
