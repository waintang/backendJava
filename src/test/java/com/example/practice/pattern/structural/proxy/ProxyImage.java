package com.example.practice.pattern.structural.proxy;

public class ProxyImage implements Image {

    //代理对象
    private RealImage realImage ;
    private String fileName;

    public ProxyImage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if(realImage==null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
