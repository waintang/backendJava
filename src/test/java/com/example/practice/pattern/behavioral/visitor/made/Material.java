package com.example.practice.pattern.behavioral.visitor.made;

// 抽象元素：材料
public interface Material {
    String accept(Company company);
}
