package com.example.practice.pattern.structural.proxy.image;

/**
 * 代理模式
 */
public class ProxyTest {

    public static void main(String[] args) {
        Image image = new ProxyImage("filenameTwp");
        image.display();
    }
}
