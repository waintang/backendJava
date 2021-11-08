package com.example.practice.pattern.behavioral.state.score;

/**
 * 上下文角色 / 主体对象（拥有 一个 分数状态）
 */
public class ScoreContext {

    public ScoreContext(){
        this.state = new LowState(this);
    }

    private AbstractState state;

    public void add(double addscore){
        this.state.addScore(addscore);
    }

    public AbstractState getState() {
        return state;
    }

    public void setState(AbstractState state) {
        this.state = state;
    }

    public void printStateName(){
        System.out.println("当前状态："+this.state.stateName);
    }
}
