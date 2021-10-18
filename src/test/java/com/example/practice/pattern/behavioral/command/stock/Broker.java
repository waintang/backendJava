package com.example.practice.pattern.behavioral.command.stock;

import java.util.ArrayList;
import java.util.List;

/**
 * invoker
 * 股市操作员(此处理解成 散户) ，操作 买入、卖出
 */
public class Broker {

//    private Order order;
//
//    public Broker(Order order){
//        this.order =order;
//    }
//
//    public void execute(){
//        order.execute();
//    }

    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order){
        orders.add(order);
    }

    public void execute(){
        for(Order order : orders){
            order.execute();
        }
    }
}
