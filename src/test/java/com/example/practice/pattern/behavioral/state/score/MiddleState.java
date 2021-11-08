package com.example.practice.pattern.behavioral.state.score;

/**
 * 具体状态类 三 /  分数状态 - 及格
 */
public class MiddleState extends AbstractState {
    public MiddleState(AbstractState state){
        this.context = state.context;
        this.score = state.score;
        this.stateName = "及格"; // 曾犯错：状态 是不一样的，其它属性 可以继承
    }
    @Override
    public void checkState() {
        if(score>=90){
            context.setState(new HighState(this));
        }else if(score <60){
            context.setState(new LowState(this));
        }
    }
}
