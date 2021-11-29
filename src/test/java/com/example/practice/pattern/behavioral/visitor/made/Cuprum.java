package com.example.practice.pattern.behavioral.visitor.made;

// 具体元素：铜
public class Cuprum implements Material{
    @Override
    public String accept(Company visitor) {
        return visitor.create(this);
    }
}
