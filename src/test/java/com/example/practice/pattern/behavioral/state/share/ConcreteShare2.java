package com.example.practice.pattern.behavioral.state.share;

public class ConcreteShare2 extends ShareState {
    @Override
    public void handle(ShareContext context) {
        System.out.println("处理二被触发，切换状态至 预定义的 一");
        context.setShareState(context.getShareState("1"));
    }
}
