package com.example.practice.pattern.behavioral.command.stock;

public class BuyOrder extends Order {

    public  BuyOrder(Stock stock){
        super(stock);
    }

    @Override
    public void execute() {
        stock.buy();
    }
}
