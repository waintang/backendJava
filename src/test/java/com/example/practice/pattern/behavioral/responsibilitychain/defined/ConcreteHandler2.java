package com.example.practice.pattern.behavioral.responsibilitychain.defined;

public class ConcreteHandler2 extends Handler {
    @Override
    void handleRequest(String request) {
        if(request.contains("two")){
            System.out.println("责任2被调用");
        }
        if(getNextHandler()!= null){
            getNextHandler().handleRequest(request);
        }else{
            System.out.println("责任链完成");
        }
    }
}
