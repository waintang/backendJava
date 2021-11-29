package com.example.practice.pattern.behavioral.visitor.defined;

// 抽象访问者
public interface Visitor {
    void visit(ConcreteElementA element);

    void visit(ConcreteElementB element);
}
