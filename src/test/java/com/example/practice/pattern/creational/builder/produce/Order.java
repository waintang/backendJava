package com.example.practice.pattern.creational.builder.produce;

/**
 * 监工角色
 * 订单
 */
public class Order {
    public void placeOrder(MealBuilder mealBuilder){
        //拿到 具体想吃什么后
        //1、打印凭据
        mealBuilder.build().printItems();
        // 2、发给厨房制作
        mealBuilder.build();
    }
}
