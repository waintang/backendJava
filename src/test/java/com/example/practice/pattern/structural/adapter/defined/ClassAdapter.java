package com.example.practice.pattern.structural.adapter.defined;

/**
 * 类适配器
 */
public class ClassAdapter extends Adaptee implements Target {
    @Override
    public void request() {
        System.out.println("类适配器");
        adapteeRequest();
    }
}
