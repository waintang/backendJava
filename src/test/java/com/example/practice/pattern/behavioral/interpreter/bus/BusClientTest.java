package com.example.practice.pattern.behavioral.interpreter.bus;

public class BusClientTest {
    public static void main(String[] args) {
        BusContext bus = new BusContext();
        bus.rideBus("韶关的老人");
        bus.rideBus("山东的成年人");
    }
}
