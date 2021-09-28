package com.example.practice.pattern.behavioral.template;

/**
 * 调研发现：
 * 板球 符合预定义的 Game规则（大概率 以后不会变）
 */
public class Cricket extends Game {
    @Override
    void initialize() {
        System.out.println("Cricket Game Initialized .");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started .");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket Game Ended .");
     }
}
