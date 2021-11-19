package com.example.practice.pattern.behavioral.mediator.defined.simple;

/**
 * 简化中介者模式（仅保留一个 单例的中介者）
 */
public class SimpleMediatorTest {
    public static void main(String[] args) {
        // 简化的中介者  直接 初始化在同事内
        Colleague colleague1 = new ConcreteColleague1();
        Colleague colleague2 = new ConcreteColleague2();
        colleague1.send("1消息");
        colleague2.send("2消息");
    }
}
