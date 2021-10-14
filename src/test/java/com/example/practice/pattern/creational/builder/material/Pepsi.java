package com.example.practice.pattern.creational.builder.material;

public class Pepsi extends ColdDrink {
    @Override
    public String name() {
        return "百事可乐";
    }

    @Override
    public float price() {
        return 3.5f;
    }
}
