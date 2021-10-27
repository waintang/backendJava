package com.example.practice.pattern.behavioral.strategy.defined;

public class ConcreteStrategyA extends Strategy {
    @Override
    public void strategyMethod() {
        System.out.println("策略A实现的策略方法strategyMethod()");
    }
}
