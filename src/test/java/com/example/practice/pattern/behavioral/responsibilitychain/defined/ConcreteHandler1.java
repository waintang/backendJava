package com.example.practice.pattern.behavioral.responsibilitychain.defined;

public class ConcreteHandler1 extends Handler {
    @Override
    void handleRequest(String request) {
        if(request.contains("one")){
            System.out.println("责任1被调用");
        }
        if(getNextHandler()!= null){
            getNextHandler().handleRequest(request);
        }else{
            System.out.println("责任链完成");
        }
    }
}
