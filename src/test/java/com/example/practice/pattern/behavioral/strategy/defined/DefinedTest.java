package com.example.practice.pattern.behavioral.strategy.defined;

/**
 * 策略模式 定义
 */
public class DefinedTest {
    public static void main(String[] args) {
        // 形式上 和 模板模式 很相像；
        // 模板模式 是 对多目标的统一模板 / 直接new调用 就能到达目标（定义类时，就已经自带上下文了）
        // 策略模式 是 对单目标的多种策略 / 需要搭配进 别的上下文、充当一个螺丝钉
//        Strategy strategy = new ConcreteStrategyA();
//        strategy.strategyMethod();

        Strategy strategy2 = new ConcreteStrategyA();
        Context context = new Context();
        context.setStrategy(strategy2);
        context.businessMethod();
    }
}
