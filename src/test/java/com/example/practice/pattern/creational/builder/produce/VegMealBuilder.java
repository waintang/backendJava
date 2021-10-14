package com.example.practice.pattern.creational.builder.produce;

import com.example.practice.pattern.creational.builder.material.Pepsi;
import com.example.practice.pattern.creational.builder.material.VegBurger;

/**
 * 具体建造者
 * 套餐二：素食主义 套餐
 */
public class VegMealBuilder extends MealBuilder {

    public VegMealBuilder(){
       super();
        suit();
    }
    @Override
    public MealBuilder suit() {
        meal.addItem(new VegBurger());
        meal.addItem(new Pepsi());
        return this;
    }
}
