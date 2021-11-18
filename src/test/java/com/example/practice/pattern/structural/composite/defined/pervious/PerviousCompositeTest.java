package com.example.practice.pattern.structural.composite.defined.pervious;

// 透明 组合模式
public class PerviousCompositeTest {
    public static void main(String[] args) {
        Component root = new Composite();
        Component dir1 = new Composite();
        Component dir2 = new Composite();
        Component leaf1 = new Leaf("leaf1");
        Component leaf2 = new Leaf("leaf2");

        dir1.add(leaf1);
        dir2.add(leaf2);
        root.add(dir1);
        root.add(dir2);

        root.operation();
    }
}
