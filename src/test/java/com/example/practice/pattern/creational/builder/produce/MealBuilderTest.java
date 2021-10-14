package com.example.practice.pattern.creational.builder.produce;

/**
 * 建造者模式  适合用于  创建复杂对象
 */
public class MealBuilderTest {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new VegMealBuilder();
//        Meal meal = mealBuilder.build();
//        meal.printItems();

        Order order = new Order();
        order.placeOrder(mealBuilder);
        Meal meal = mealBuilder.build();

        meal.printItems();
    }
}
