package com.example.practice.pattern.behavioral.observer.customer;

public class CustomerObserverTest {
    public static void main(String[] args) {

        Subject subject = new Subject();
        BinaryObserver binaryObserver = new BinaryObserver(subject);
        subject.setState(13);
    }
}
