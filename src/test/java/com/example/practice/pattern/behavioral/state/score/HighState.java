package com.example.practice.pattern.behavioral.state.score;

/**
 * 具体状态类 一 /  分数状态 - 优秀
 */
public class HighState extends AbstractState {
    public HighState(AbstractState state){
        this.context = state.context;
        this.score = state.score;
        this.stateName = "优秀"; // 曾犯错：状态 是不一样的，其它属性 可以继承
    }
    @Override
    public void checkState() {
        if(score<60){
            context.setState(new LowState(this)); // 状态 传 状态，注意
        }else if(score<90){
            context.setState(new MiddleState(this));
        }
    }
}
