package com.example.practice.pattern.creational.builder.produce;

/**
 * 具体建造者
 * 非套餐自选套餐
 */
public class SelfMealBuilder extends MealBuilder {
    @Override
    public MealBuilder suit() {
        return this;
    }
}
