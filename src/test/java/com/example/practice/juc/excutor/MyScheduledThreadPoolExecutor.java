package com.example.practice.juc.excutor;

import java.util.concurrent.*;

public class MyScheduledThreadPoolExecutor extends ScheduledThreadPoolExecutor {
    public MyScheduledThreadPoolExecutor(int corePoolSize) {
        super(corePoolSize);
    }

    /**
     * 装饰 Runnable任务=》ScheduledThreadPoolExecutor.decorateTask() 默认返回装饰好的
     *      此处MyScheduledFutureTask类内部决定以哪个为准
     * @param runnable the submitted Runnable
     * @param task the task created to execute the runnable
     * @return
     * @param <V>
     */
    @Override
    protected <V> RunnableScheduledFuture<V> decorateTask(Runnable runnable, RunnableScheduledFuture<V> task) {
        return new MyScheduledFutureTask<>(runnable, null, task);
    }
}