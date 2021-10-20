package com.example.practice.pattern.behavioral.responsibilitychain.defined;

public abstract class Handler {

    private Handler nextHandler ;

    public Handler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    abstract void handleRequest(String request);

}
