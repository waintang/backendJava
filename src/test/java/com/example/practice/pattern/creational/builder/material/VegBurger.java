package com.example.practice.pattern.creational.builder.material;

public class VegBurger extends Burger {
    @Override
    public String name() {
        return "蔬菜汉堡";
    }

    @Override
    public float price() {
        return 12.5f;
    }
}
