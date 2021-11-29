package com.example.practice.pattern.behavioral.visitor.computer;

// 具体角色 - 键盘
public class Keyboard implements ComputerPart{
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
