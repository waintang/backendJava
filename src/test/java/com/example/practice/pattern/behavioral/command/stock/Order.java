package com.example.practice.pattern.behavioral.command.stock;

/**
 * command 下单/传递的订单：
 * 真实 买卖 需要传递的信息
 */
public abstract class Order {

    // command 依赖 receiver实现真实动作
    protected Stock stock;

    public Order(Stock stock){
        this.stock = stock;
    }

    public abstract void execute();
}
