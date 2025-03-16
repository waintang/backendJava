package com.example.practice.juc.excutor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RunnableScheduledFutureExample {
    public static void main(String[] args) {
        // 创建自定义调度器
        MyScheduledThreadPoolExecutor executor = new MyScheduledThreadPoolExecutor(2);
//        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(2);

        // 创建任务
        Runnable task1 = new MyTask("Task 1");
        Runnable task2 = new MyTask("Task 2");

        // 调度任务
//        executor.schedule(task1, 2, TimeUnit.SECONDS); // 延迟 2 秒执行
        executor.scheduleAtFixedRate(task2, 1, 3, TimeUnit.SECONDS); // 延迟 1 秒后，每 3 秒执行一次

        // 关闭调度器
        try {
            Thread.sleep(10000); // 主线程休眠 10 秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }
}