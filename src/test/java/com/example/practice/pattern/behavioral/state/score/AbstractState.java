package com.example.practice.pattern.behavioral.state.score;

/**
 * 抽象状态类 /  分数状态
 */
public abstract class AbstractState {
    protected ScoreContext context;
    protected String stateName;
    protected double score;

    public abstract void checkState();

    public void addScore(double addScore){
        this.score += addScore;
        System.out.printf("加上"+addScore+"分，当前分数："+this.score);
        // 不同状态 更改到  下一个不同状态
        checkState();
//        System.out.println("，当前状态："+this.stateName);
        System.out.println("，当前状态："+this.context.getState().stateName); // 曾犯错：context上下文/主体类 的 状态 发生变化
    }
}
