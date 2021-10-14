package com.example.practice.pattern.creational.builder.material;

public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "鸡肉汉堡";
    }

    @Override
    public float price() {
        return 19.5f;
    }
}
