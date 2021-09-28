package com.example.practice.pattern.behavioral.template;

public abstract class Game {

    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    /**
     * 模板方法（即 通用算法） 【重要：不能被重写】
     *
     * 此例定义 通用算法：游戏准备、开始游戏、结束游戏 三步
     *
     */
    public final void play(){
        initialize();
        startPlay();
        endPlay();
    }
}
