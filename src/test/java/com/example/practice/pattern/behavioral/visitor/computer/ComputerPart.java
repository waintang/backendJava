package com.example.practice.pattern.behavioral.visitor.computer;

// 抽象元素 角色
public interface ComputerPart {
    public void accept(ComputerPartVisitor computerPartVisitor);
}
