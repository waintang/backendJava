package com.example.practice.pattern.behavioral.visitor.computer;

// 具体访问者
public class ComputerPartDisplayVisitor implements ComputerPartVisitor{
    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("keyboard displaying.");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("mouse displaying.");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("monitor displaying.");
    }

    @Override
    public void visit(Computer computer) {
        System.out.println("computer displaying.");
    }
}
