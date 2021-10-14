package com.example.practice.pattern.creational.builder.produce;

import com.example.practice.pattern.creational.builder.material.Burger;
import com.example.practice.pattern.creational.builder.material.ColdDrink;

/**
 * 抽象建造者角色
 * 可以单点、可以套餐、也可以套餐+单点
 */
public abstract class MealBuilder {

    public Meal meal = new Meal();

    public MealBuilder burger(Burger burger){
        meal.addItem(burger);
        return this;
    }

    public MealBuilder coldDrink(ColdDrink coldDrink){
        meal.addItem(coldDrink);
        return this;
    }

    public Meal build(){
        return meal;
    }

    public abstract MealBuilder suit();

/*
    public interface Builder{
        public BuilderImpl builder();
        public MealBuilder build();
    }

    public class BuilderImpl implements Builder{

        private Meal meal;

        @Override
        public MealBuilder.Builder builder() {
            return this;
        }

        @Override
        public MealBuilder build() {
            return null;
        }
    }*/
}
