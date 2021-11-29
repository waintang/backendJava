package com.example.practice.pattern.behavioral.visitor.computer;

// 抽象访问者 角色
public interface ComputerPartVisitor {
    public void visit(Keyboard keyboard);
    public void visit(Mouse mouse);
    public void visit(Monitor monitor);
    public void visit(Computer computer);
}
