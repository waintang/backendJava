package com.example.practice.pattern.behavioral.mediator.defined.standard;

public class ConcreteColleague1 extends Colleague{
    /*public ConcreteColleague1(Mediator mediator){
        this.mediator = mediator;
    }*/
    @Override
    public void send(String info) {
        System.out.println("同事1发送消息："+info);
        mediator.relay(this,info);
    }

    @Override
    public void receive(String info) {
        System.out.println("同事1收到消息："+info);
    }
}
