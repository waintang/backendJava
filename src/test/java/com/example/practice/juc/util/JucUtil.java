package com.example.practice.juc.util;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class JucUtil {

    public Object submitForkTask(Callable runnable){
        // todo 为什么用ForkJoinPool？
        // todo 服务器满，导致线程池申请不下来，哪个阶段报错？
        ForkJoinPool forkJoinPool = new ForkJoinPool(8);
        try{
            return forkJoinPool.submit(runnable).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            forkJoinPool.shutdown();
        }

    }
}
