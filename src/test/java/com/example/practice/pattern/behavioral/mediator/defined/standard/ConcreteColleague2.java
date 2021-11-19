package com.example.practice.pattern.behavioral.mediator.defined.standard;

public class ConcreteColleague2 extends Colleague {
    /*public ConcreteColleague2(Mediator mediator){
        this.mediator = mediator;
    }*/

    @Override
    public void send(String info) {
        System.out.println("同事2发送消息："+info);
        mediator.relay(this,info);
    }

    @Override
    public void receive(String info) {
        System.out.println("同事2收到消息："+info);
    }
}
