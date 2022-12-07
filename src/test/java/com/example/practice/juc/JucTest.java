package com.example.practice.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JucTest {

    private static AtomicLong atomicLong = new AtomicLong();
    BlockingQueue blockingQueue = new ArrayBlockingQueue(10);
    // AQS同步队列：https://blog.csdn.net/weixin_43935927/article/details/113901484
    Lock lock = new ReentrantLock();
    // 条件队列：https://blog.csdn.net/qq_33762302/article/details/114381258
    Condition notFull = lock.newCondition();

    public static void main(String[] args) {
        System.out.println(atomicLong);
        long updatedLong = atomicLong.addAndGet(-1); // 返回-1
        long previousLong = atomicLong.getAndAdd(-1); // 返回-1
        System.out.println(atomicLong); // 返回-2

    }
}
