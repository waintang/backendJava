package com.example.practice.concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadTest extends Thread{
    public static void main(String[] args) {
        // 1、固定间隔、循环执行任务
        ScheduledExecutorService timer = Executors.newSingleThreadScheduledExecutor();

        System.out.printf("开始时间：%s\n\n", new SimpleDateFormat("HH:mm:ss").format(new Date()));
        TimerTask timerTask = new TimerTask(5000);
        timer.scheduleAtFixedRate(timerTask,1000, 3000, TimeUnit.MILLISECONDS);
    }

    private static class TimerTask implements Runnable {
        private final int sleepTime;
        private final SimpleDateFormat dateFormat;

        public TimerTask(int sleepTime){
            this.sleepTime = sleepTime;
            this.dateFormat = new SimpleDateFormat("HH:mm:ss");
        }

        @Override
        public void run() {
            System.out.println("任务开始，当前时间："+dateFormat.format(new Date()));
            try {
                System.out.println("默认任务允许...");
                Thread.sleep(sleepTime);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
            System.out.println("任务结束，当前时间："+dateFormat.format(new Date()));
            System.out.println();
        }
    }
}
