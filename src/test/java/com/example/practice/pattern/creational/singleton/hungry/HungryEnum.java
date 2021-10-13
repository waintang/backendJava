package com.example.practice.pattern.creational.singleton.hungry;

/**
 * 五、饿汉模式 - 登记式  内部枚举方式 登记
 * 线程 安全（靠 classLoader机制保证）
 * 性能 。。。
 *
 * Lazy初始化：饿汉模式 除 登记式-内部静态类方式 外，都是 非 延迟初始化
 */
public class HungryEnum {

    private HungryEnum() {
//        if(SingletonEnum.INSTANCE !=null ){
//            throw new RuntimeException("单例模式,禁止多实例");
//        }
    }

    public static HungryEnum getInstance(){
        return SingletonEnum.INSTANCE.getInstance();
    }

    public void print(){
        System.out.println("HungryEnum::print");
    }

    // 枚举 封装 单例对象
    static enum SingletonEnum{
        INSTANCE;

        private HungryEnum instance;

        private SingletonEnum(){
            // 自定义 引用对象 的 private构造函数
            this.instance = new HungryEnum();
        }

        public HungryEnum getInstance(){
            return this.instance;
        }
    }

}
