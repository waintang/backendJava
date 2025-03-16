package com.example.practice.juc.excutor;
import java.util.concurrent.*;

public class MyScheduledFutureTask<V> extends FutureTask<V> implements RunnableScheduledFuture<V> {
    private final RunnableScheduledFuture<V> task;

    /**
     * RunnableScheduledFuture = runnable + 延迟 + 周期；
     * 局限：此处只往父类传runnable；即：要用task 需子类自己用
     * @param runnable
     * @param result
     * @param task
     */
    public MyScheduledFutureTask(Runnable runnable, V result, RunnableScheduledFuture<V> task) {
        super(runnable, result);
        this.task = task;
    }

    @Override
    public boolean isPeriodic() {
        return task.isPeriodic();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return task.getDelay(unit);
    }

    @Override
    public int compareTo(Delayed o) {
        return task.compareTo(o);
    }

    @Override
    public void run() {
        task.run();
    }
}