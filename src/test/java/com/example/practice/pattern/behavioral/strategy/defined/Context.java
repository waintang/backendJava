package com.example.practice.pattern.behavioral.strategy.defined;

public class Context {
    private Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void businessMethod(){
        //业务逻辑中，某步有好几种算法可共选择
        strategy.strategyMethod();
    }
}
