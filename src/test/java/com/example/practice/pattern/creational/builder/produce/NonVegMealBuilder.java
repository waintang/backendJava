package com.example.practice.pattern.creational.builder.produce;

import com.example.practice.pattern.creational.builder.material.ChickenBurger;
import com.example.practice.pattern.creational.builder.material.Coke;

/**
 * 具体建造者
 * 套餐一：纯肉食 + 肥宅快乐套餐
 */
public class NonVegMealBuilder extends MealBuilder {

    public NonVegMealBuilder(){
        super();
        suit();
    }

    @Override
    public MealBuilder suit() {
        meal.addItem(new ChickenBurger());
        meal.addItem(new Coke());
        return this;
    }
}
