package com.example.practice.pattern.behavioral.mediator.estate;

public class DatingPlatformMain {
    public static void main(String[] args) {
        Mediator mediator = new EstateMediator();
        Customer seller = new Seller("卖家唐");
        Customer buyerA = new Buyer("买家A");
        Customer buyerB = new Buyer("买家B");
        // 中介者 统一牵线 买方、买方
        mediator.register(seller);
        mediator.register(buyerA);
        mediator.register(buyerB);
        buyerA.send("房子还在吗？");
    }
}
