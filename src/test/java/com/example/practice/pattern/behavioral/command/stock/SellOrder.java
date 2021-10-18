package com.example.practice.pattern.behavioral.command.stock;

public class SellOrder extends Order {

    public  SellOrder(Stock stock){
        super(stock);
    }

    @Override
    public void execute() {
        stock.sell();
    }
}
