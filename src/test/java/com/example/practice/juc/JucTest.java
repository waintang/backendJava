package com.example.practice.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JucTest {
    BlockingQueue blockingQueue = new ArrayBlockingQueue(10);
    Lock lock = new ReentrantLock();
    Condition notFull = lock.newCondition();
}
