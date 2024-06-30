package com.example.practice;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolExample {
    public static void main(String[] args) throws InterruptedException {
        // 创建一个固定大小的线程池
        ExecutorService executor = Executors.newFixedThreadPool(5);
        ExecutorService executor1 = Executors.newCachedThreadPool();
        ExecutorService executor2 = Executors.newSingleThreadExecutor();
        ScheduledExecutorService executor3 = Executors.newScheduledThreadPool(5);

        // 创建一个任务列表
        List<Callable<String>> tasks = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            int tempI = i;
            tasks.add(() -> {
                // 模拟任务执行
                Thread.sleep(1000);
                return "Task " + tempI + " completed";
            });
        }

        // 执行任务列表
        List<Future<String>> futures = executor.invokeAll(tasks);

        // 关闭线程池
        executor.shutdown();

        // 输出任务执行结果
        for (Future<String> future : futures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
