package com.example.practice.pattern.behavioral.strategy.advance;

/**
 *
 * 生产环境、一般的， 策略模式 都会搭配 工厂模式 使用
 */
public class StrategyAdvanceTest {

    public static void main(String[] args) {
        ContextAdvance contextAdvance = new ContextAdvance();
        Object obj = contextAdvance.executeContext(5L,"+");
        System.out.println("策略模式+工厂模式 加法：" + obj );

        obj = contextAdvance.executeContext(5L,"/");
        System.out.println("策略模式+工厂模式 除法：" + obj );
    }

}
