package com.example.practice.pattern.behavioral.visitor.made;

// 抽象访问者
public interface Company {
    String create(Paper paper);
    String create(Cuprum cuprum);
}
