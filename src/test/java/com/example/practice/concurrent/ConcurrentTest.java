package com.example.practice.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description：涉及锁、volatile、CAS等
 * @author：tavion
 * @date：2021/1/21 10:52
 */
public class ConcurrentTest {
    static AtomicInteger x = new AtomicInteger(0);

    public static void main(String[] args) {
        x.incrementAndGet();
    }
}
