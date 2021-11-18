package com.example.practice.pattern.structural.composite.defined.pervious;

import java.util.List;

public class Leaf implements Component{

    public Leaf(String name){
        this.name = name;
    }

    private String name ;

    @Override
    public void operation() {
        System.out.println("当前叶子节点："+name);
    }

    @Override
    public void add(Component component) {

    }

    @Override
    public void remove(Component component) {

    }

    @Override
    public List<Component> getChilds() {
        return null;
    }
}
