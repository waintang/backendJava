package com.example.practice.pattern.structural.observer.jdk;

import java.util.Observable;

/**
 * 可被观察的
 */
public class Subject extends Observable {
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        // 某个字段变更，通知所有 观察者
        this.setChanged();
        this.notifyObservers();
    }
}
