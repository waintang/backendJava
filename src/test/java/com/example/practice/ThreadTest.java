package com.example.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ThreadTest {
    public static ThreadLocal<Map<String,Object>> threadLocal = new ThreadLocal<>();
    public static void main1(String[] args) {
        // ########### Thread.interrupt中断、Thread.interrupted判断是否中断
        System.out.println("开始测试：Thread.interrupt中断、Thread.interrupted判断是否中断");
        InterruptRunnable interruptRunnable = new InterruptRunnable();
        Thread interruptThread = new Thread(interruptRunnable);
        interruptThread.start();
        try {
            System.out.println("开始睡眠");
            Thread.sleep(1000);
            System.out.println("结束睡眠");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        interruptThread.interrupt();
        System.out.println("结束测试：Thread.interrupt中断、Thread.interrupted判断是否中断");
        // ########### threadLocal
        TwpThread twpThread1 = new TwpThread();
        TwpThread twpThread2 = new TwpThread();
        new Thread(twpThread1).start();
        new Thread(twpThread2).start();
    }


    public static class InterruptRunnable implements Runnable{

        @Override
        public void run() {
            while(!Thread.interrupted()){
                System.out.println(1);
            }
            System.out.println("退出循环");
            for(int i = 0;i<100;i++){
                System.out.println(i);
            }
        }
    }

    public static class TwpThread implements Runnable{

        @Override
        public void run() {
            Long threadId = Thread.currentThread().getId();
            System.out.println("===开始线程："+threadId);
            Map<String,Object> map = new HashMap<>();
            Random random = new Random();
            int a = random.nextInt();
            // 设置ThreadLocal
            map.put(threadId+":twp:"+a,a);
            threadLocal.set(map);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("===等待："+threadId);
            // 获取ThreadLocal
            Map<String,Object> result = threadLocal.get();
            System.out.println(result);
        }
    }
}
