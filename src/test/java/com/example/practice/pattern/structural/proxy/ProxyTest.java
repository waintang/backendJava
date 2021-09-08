package com.example.practice.pattern.structural.proxy;

public class ProxyTest {

    public static void main(String[] args) {
        Image image = new ProxyImage("filenameTwp");
        image.display();
    }
}
