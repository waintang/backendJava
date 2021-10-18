package com.example.practice.pattern.behavioral.command.stock;

/**
 * receiver
 * 股票 真正操作的 目标（最终节点）
 */
public class Stock {

    private String name ;
    private int quantity;

    public Stock(String name,int quantity){
        this.name = name;
        this.quantity = quantity;
    }

    public void buy(){
        System.out.println("买"+name+quantity+" 手。");
    }
    public void sell(){
        System.out.println("卖出"+name+quantity+" 手");
    }

}
