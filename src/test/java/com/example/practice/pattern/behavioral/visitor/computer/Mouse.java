package com.example.practice.pattern.behavioral.visitor.computer;

// 具体角色 - 鼠标
public class Mouse implements ComputerPart{
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
