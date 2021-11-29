package com.example.practice.pattern.behavioral.memento.defined;

// 发起人
public class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento createMemento(){
        return new Memento(this.state);
    }

    public void restoreMemento(Memento m){
        this.setState(m.getState());
    }

}
