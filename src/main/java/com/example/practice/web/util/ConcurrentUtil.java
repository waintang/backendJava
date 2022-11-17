package com.example.practice.web.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public class ConcurrentUtil {
    private static final Logger LOG = LoggerFactory.getLogger(ConcurrentUtil.class);
    // 大list 拆分成 多个小list，多线程同时进行

    /**
     *
     * @param dataList 需要处理的数据
     * @param maxThread 线程数
     * @param threadSize 每个线程处理数据数
     * @param taskPool 线程池
     * @param function 线程执行函数
     * @param <T> 函数输入值
     * @param <R> 函数返回值
     * @return
     */
    public static <T, R> List<R> runnerOperation(final List<T> dataList, final int maxThread, int threadSize, ThreadPoolTaskExecutor taskPool,
                                                 final Function<List<T>, List<R>> function) {
        LOG.info("CommonPayloadUtil config threadCount is {},threadSize is {}", maxThread, threadSize);

        List<List<T>> splitList = splitList(dataList, threadSize);
        //List<R> resDataList = new ArrayList<>(dataList.size());
        List<R> resDataList = Collections.synchronizedList(new ArrayList<>(dataList.size()));
        if (CollectionUtils.isEmpty(splitList)) {
            LOG.error("request data is null return null");
            return null;
        }
        if (splitList.size() == 1) {
            resDataList = function.apply(dataList);
        } else {
            // 多线程分配策略
            final List<Future<String>> results = new ArrayList<>();
            final AtomicInteger taskCounter = new AtomicInteger(0);
            final CountDownLatch countDownLatch = new CountDownLatch(splitList.size());
            // 举例：100个集合 循环/排队 让10个线程处理（线程满时，集合数据 自循环等待 线程空闲）
            for (List<T> currentBatchProcess : splitList) {
                results.add(taskRunner(currentBatchProcess, maxThread, taskPool, taskCounter, resDataList, function));
            }
            // 等待调度的线程执行结束
            for (final Future<String> result : results) {
                try {
                    result.get();
                } catch (final Exception e) {
                    LOG.error("ConcurrentUtil thread happened error,{}", e);
                }finally {
                    countDownLatch.countDown();
                }
            }
            try {
                countDownLatch.await();
            }catch (Exception e){
                LOG.error("阻塞等待异常，{}", e);
            }
        }
        return resDataList;
    }

    /**
     *
     *
     * @param preProcessDatas 待处理的集合
     * @param maxThread 最大线程数
     * @param taskCounter 实际任务数
     * @param resDataList 处理结束后的结果集
     * @return
     */
    public static <T, R> Future<String> taskRunner(final List<T> preProcessDatas,
                                                   final int maxThread, ThreadPoolTaskExecutor taskPool,
                                                   final AtomicInteger taskCounter,
                                                   final List<R> resDataList, final Function<List<T>, List<R>> function) {

        final Callable<String> taskRunner = () -> {
            try {
                LOG.info("EpoCommonPayloadUtil start new thread,taskRunner process ({}) records.", preProcessDatas.size());
                resDataList.addAll(function.apply(preProcessDatas));
            } catch (final Exception e) {
                LOG.error("taskRunner error", e);
            } finally {
                int i = taskCounter.decrementAndGet();
                LOG.info("release the num is {}", i);
            }
            return "success";
        };
        while (true) {
            int i = taskCounter.get();
            if (i < maxThread) {
                taskCounter.incrementAndGet();
                LOG.info("continue to submit{}", i);
                // 此处线程池满时、若还不停进”人/数据“，会RejectedExecutionException
                return taskPool.submit(taskRunner);
            }
        }
    }



    /**
     * @param sourceList
     * @param perListSize
     * @return 子List集合
     * @author youlong.peng
     * @description 按指定大小，分隔集合List，将集合按规定个数分为n个部分
     */
    public static <T> List<List<T>> splitList(List<T> sourceList, int perListSize) {
        if (sourceList == null || sourceList.size() == 0 || perListSize < 1) {
            return null;
        }

        List<List<T>> result = new ArrayList<List<T>>();

        int size = sourceList.size();
        int count = (size + perListSize - 1) / perListSize;

        for (int i = 0; i < count; i++) {
            List<T> subList = sourceList.subList(i * perListSize, ((i + 1)
                    * perListSize > size ? size : perListSize * (i + 1)));
            result.add(subList);
        }
        return result;
    }
}
