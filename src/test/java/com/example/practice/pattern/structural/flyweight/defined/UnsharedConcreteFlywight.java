package com.example.practice.pattern.structural.flyweight.defined;

// 非享元角色
public class UnsharedConcreteFlywight {
    private String info;
    public UnsharedConcreteFlywight(String info){
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
