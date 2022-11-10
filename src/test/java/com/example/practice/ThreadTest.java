package com.example.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ThreadTest {
    public static ThreadLocal<Map<String,Object>> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {
        TwpThread twpThread1 = new TwpThread();
        TwpThread twpThread2 = new TwpThread();
        new Thread(twpThread1).start();
        new Thread(twpThread2).start();
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
