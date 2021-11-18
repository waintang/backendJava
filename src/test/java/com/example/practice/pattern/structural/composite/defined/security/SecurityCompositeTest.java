package com.example.practice.pattern.structural.composite.defined.security;


// 安全 组合模式
public class SecurityCompositeTest {
    public static void main(String[] args) {
        Composite root = new Composite();
        Composite dir1 = new Composite();
        Composite dir2 = new Composite();
        Component leaf1 = new Leaf("leaf1");
        Component leaf2 = new Leaf("leaf2");

        dir1.add(leaf1);
        dir2.add(leaf2);
        root.add(dir1);
        root.add(dir2);

        root.operation();
    }
}
