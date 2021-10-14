package com.example.practice.pattern.structural.observer.customer;

public class CustomerObserverTest {
    public static void main(String[] args) {

        Subject subject = new Subject();
        BinaryObserver binaryObserver = new BinaryObserver(subject);
        subject.setState(13);
    }
}
