package com.example.practice.pattern.behavioral.observer.jdk;

/**
 * java提供了java.util.Observable 和 java.util.Observer
 * google guava提供了EventBus事件总线实现观察者模式，@Subscribe观察指定的事件类型以及父类型，被观察者发送消息到EventBus
 * Spring也提供了框架：Event事件，Listener监听者（观察者），Publisher发送者（被观察者）
 *      借助ApplicationEventPublisher.publishEvent()发布消息到ApplicationContext，spring会查找实现了ApplicationListener的类调用其中的onApplicationEvent()
 */
public class JdkObserverTest {
    public static void main(String[] args) {
        Subject subject = new Subject();
        BinaryObserver binaryObserver = new BinaryObserver(subject);
        subject.setState(12);
    }

}
