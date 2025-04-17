package com.example.practice;

import cn.hutool.log.Log;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

/**
 * synchronized的可见性、
 * java.util.logging.Logger.info有syncronized、sout也有Synchronized
 * AbstractQueuedSynchronizer、AtomicInteger有封装volatile变量
 * 自定义类Test的volatile变量用上了（没用上不会触发“可见性”）
 */
public class SynchronizeTest {
    // sout中的synchronized的可见性，效果等同于volatile
    public static  Boolean flag = false;
    public static Lock lock = new ReentrantLock();
    public static Logger logger = Logger.getLogger("SynchronizeTest");
    public static void main(String[] args) {
        // 子线程 读 主线程的变量值
        new Thread(() -> {
            while (!flag){
//                System.out.println("试试sout");

//                new Test();
                new Test(1);

//                lock.lock();
//                lock.unlock();

//                logger.info("试试logger");

//                  int i = 0;
//                AtomicInteger i = new AtomicInteger(1);
            }
            System.out.println("子线程结束");
        }).start();

        // 主线程修改主线程的变量值
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("主线程结束");
    }

    public static class Test{
        // 用上、没用上，对子线程的可见性有影响
        volatile int waitStatus;

        Test(int i){
            waitStatus = i;
        }
        Test(){
        }
    }
}
