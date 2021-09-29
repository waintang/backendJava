package com.example.practice.pattern.creational.factory.abstractive;

/**
 * 抽象工厂 ：多个产品
 * 工厂：     一个产品
 */
public class AbstractiveFactoryTest {
    public static void main(String[] args) {
        // Dell 的PC
        PcFactory dellPcFactory = new DellPcFactory();
        // 未来可拓展成 返回 Pc对象
        dellPcFactory.createPc();
    }
}
