package com.example.practice.pattern.behavioral.memento.defined;

public class DefinedTest {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        originator.setState("10");
        System.out.println("初始状态："+originator.getState());
        // 单状态备份
        Memento memento = originator.createMemento();
        caretaker.setMemento(memento);

        originator.setState("20");
        System.out.println("第二次状态："+originator.getState());

        originator.restoreMemento(caretaker.getMemento());
        System.out.println("还原后的状态："+originator.getState());
    }
}
