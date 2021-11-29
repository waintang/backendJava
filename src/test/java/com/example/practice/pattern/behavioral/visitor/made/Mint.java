package com.example.practice.pattern.behavioral.visitor.made;

// 具体访问者
public class Mint implements Company{
    @Override
    public String create(Paper paper) {
        return "纸币";
    }

    @Override
    public String create(Cuprum cuprum) {
        return "铜币";
    }
}
