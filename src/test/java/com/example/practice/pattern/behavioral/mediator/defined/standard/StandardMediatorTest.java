package com.example.practice.pattern.behavioral.mediator.defined.standard;

public class StandardMediatorTest {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        // 曾犯错：同事保存中介者；同事注册进中介者  两个动作 一般建议放在一起，而不是这样分开set
        /*Colleague colleague1 = new ConcreteColleague1(mediator);
        Colleague colleague2 = new ConcreteColleague2(mediator);
        mediator.register(colleague1);
        mediator.register(colleague2);*/
        Colleague colleague1 = new ConcreteColleague1();
        Colleague colleague2 = new ConcreteColleague2();
        mediator.register(colleague1);
        mediator.register(colleague2);
        colleague1.send("1消息");
        colleague2.send("2消息");
    }
}
