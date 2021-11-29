package com.example.practice.pattern.behavioral.visitor.computer;

// 具体角色 - 显示器
public class Monitor implements ComputerPart{
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
