package com.example.practice.pattern.structural.proxy.defined;

public class Proxy implements Subject {
    private RealSubject realSubject ;

    @Override
    public void request() {
        if(realSubject == null){
            realSubject = new RealSubject();
        }
        preRequest();
        realSubject.request();
        postRequest();
    }

    public void preRequest(){
        System.out.println("preRequest.");
    }

    public void postRequest(){
        System.out.println("postRequest.");
    }

}
