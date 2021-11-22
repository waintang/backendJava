package com.example.practice.pattern.behavioral.mediator.estate;

public class Buyer extends Customer {
    public Buyer(String name){
        this.name = name;
    }

    @Override
    public void send(String info) {
        System.out.println(name+",您已群发了一条消息:"+info);
        mediator.relay(name,info);
    }

    @Override
    public void receive(String from, String info) {
        System.out.println(name+"已接收到"+from+"的消息："+info);
    }
}
