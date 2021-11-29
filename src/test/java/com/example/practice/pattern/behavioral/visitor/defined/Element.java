package com.example.practice.pattern.behavioral.visitor.defined;

// 抽象元素类
public interface Element {
    void accept(Visitor visitor);
}
