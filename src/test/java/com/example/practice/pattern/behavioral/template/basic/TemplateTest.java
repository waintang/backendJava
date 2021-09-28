package com.example.practice.pattern.behavioral.template.basic;

/**
 * 模板模式：手动new对象，暂不考虑复用
 */
public class TemplateTest {
    public static void main(String[] args) {
        TemplateContext templateContext = new TemplateContext();
        //模拟 请求api
        // 调用 某个运动/算法
        templateContext.playCricket();
        templateContext.playFootball();
    }
}
