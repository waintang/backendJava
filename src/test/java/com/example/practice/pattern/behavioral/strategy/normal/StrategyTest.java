package com.example.practice.pattern.behavioral.strategy.normal;

/**
 * 一般的，仅考虑策略模式
 */
public class StrategyTest {

    /**
     * 模拟请求 触发（但 这里需要手动 实例化策略）
     * @param args
     */
    public static void main(String[] args) {

        Context context = new Context(new AddOperation());
        Object result = context.executeContext(5);
        System.out.println("AddOperation:"+result.toString());

        context = new Context(new DivideOperation());
        result = context.executeContext(5);
        System.out.println("DivideOperation:"+result.toString());
    }

}
