package com.example.practice.pattern.structural.composite.defined.security;

import java.util.List;

public class Leaf implements Component {

    public Leaf(String name){
        this.name = name;
    }

    private String name ;

    @Override
    public void operation() {
        System.out.println("当前叶子节点："+name);
    }

}
