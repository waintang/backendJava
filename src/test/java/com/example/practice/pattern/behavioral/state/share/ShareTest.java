package com.example.practice.pattern.behavioral.state.share;

public class ShareTest {
    public static void main(String[] args) {
        ShareContext context = new ShareContext();
        context.handle();
        context.handle();
    }
}
