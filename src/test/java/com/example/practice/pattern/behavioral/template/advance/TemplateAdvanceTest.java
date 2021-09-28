package com.example.practice.pattern.behavioral.template.advance;

/**
 * 模板模式：配合 简单工厂 测试
 */
public class TemplateAdvanceTest {
    public static void main(String[] args) {
        ContextAdvance contextAdvance = new ContextAdvance();
        //模拟 请求api
        // 调用 某个运动/算法
        contextAdvance.playCricket();
        contextAdvance.playFootball();

    }
}
