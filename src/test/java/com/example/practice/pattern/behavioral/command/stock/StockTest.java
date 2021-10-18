package com.example.practice.pattern.behavioral.command.stock;

/**
 * 散户  提交订单  买卖股票
 */
public class StockTest {
    public static void main(String[] args) {
        //receiver
        Stock stock = new Stock("上海汉得300170",10);
        //command  （receiver 可以默认在command里，也可以此处实际调用时指定）
        BuyOrder buyOrder = new BuyOrder(stock);
        SellOrder sellOrder = new SellOrder(stock);
        //invoker
        // 此处 有用到 组合模式
        Broker broker = new Broker();
        broker.addOrder(buyOrder);
        broker.addOrder(sellOrder);
        broker.execute();
    }
}
