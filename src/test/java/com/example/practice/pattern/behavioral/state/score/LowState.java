package com.example.practice.pattern.behavioral.state.score;

/**
 * 具体状态类 二 /  分数状态 - 不及格
 */
public class LowState extends AbstractState {
    public LowState(ScoreContext context){
        this.context = context;
        stateName = "不及格";
        score = 0;
    }

    public LowState(AbstractState state){
        this.context = state.context;
        this.score = state.score;
        this.stateName = "不及格"; // 曾犯错：状态 是不一样的，其它属性 可以继承
    }

    @Override
    public void checkState() {
        if(score>=90){
            context.setState(new HighState(this)); // 状态 传 状态，注意
        }else if(score>=60){
            context.setState(new MiddleState(this));
        }
    }
}
