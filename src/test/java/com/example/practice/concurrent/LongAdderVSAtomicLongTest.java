package com.example.practice.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @description：LongAdder VS AtomicLong测试前者分散热点、减少cas自旋、减少cpu浪费
 * @author：tavion
 * @date：2021/1/22 11:31
 */
public class LongAdderVSAtomicLongTest {
    public static void main(String[] args){
        testAtomicLongVSLongAdder(1, 10000000);
        testAtomicLongVSLongAdder(10, 10000000);
        testAtomicLongVSLongAdder(20, 10000000);
        testAtomicLongVSLongAdder(40, 10000000);
        testAtomicLongVSLongAdder(80, 10000000);
    }

    static void testAtomicLongVSLongAdder(final int threadCount, final int times){
        try {
            System.out.println("threadCount：" + threadCount + ", times：" + times);
            long start = System.currentTimeMillis();
            testLongAdder(threadCount, times);
            System.out.println("LongAdder elapse：" + (System.currentTimeMillis() - start) + "ms");

            long start2 = System.currentTimeMillis();
            testAtomicLong(threadCount, times);
            System.out.println("AtomicLong elapse：" + (System.currentTimeMillis() - start2) + "ms");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void testAtomicLong(final int threadCount, final int times) throws InterruptedException {
        AtomicLong atomicLong = new AtomicLong();
        List<Thread> list = new ArrayList<>();
        for (int i=0;i<threadCount;i++){
            list.add(new Thread(() -> {
                for (int j = 0; j<times; j++){
                    atomicLong.incrementAndGet();
                }
            }));
        }

        for (Thread thread : list){
            thread.start();
        }

        for (Thread thread : list){
            thread.join();
        }
    }

    static void testLongAdder(final int threadCount, final int times) throws InterruptedException {
        LongAdder longAdder = new LongAdder();
        List<Thread> list = new ArrayList<>();
        for (int i=0;i<threadCount;i++){
            list.add(new Thread(() -> {
                for (int j = 0; j<times; j++){
                    longAdder.add(1);
                }
            }));
        }

        for (Thread thread : list){
            thread.start();
        }

        for (Thread thread : list){
            thread.join();
        }
    }
}
