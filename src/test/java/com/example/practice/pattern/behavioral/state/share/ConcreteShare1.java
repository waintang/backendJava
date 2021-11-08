package com.example.practice.pattern.behavioral.state.share;

public class ConcreteShare1 extends ShareState {
    @Override
    public void handle(ShareContext context) {
        System.out.println("处理一被触发，切换状态至 预定义的 二");
        context.setShareState(context.getShareState("2"));
    }
}
