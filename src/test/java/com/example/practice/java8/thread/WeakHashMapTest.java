package com.example.practice.java8.thread;

import com.carrotsearch.sizeof.RamUsageEstimator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.WeakHashMap;
import java.util.stream.Collectors;

public class WeakHashMapTest {
    public static int M = 1024*1024;

    public static void printlnMemory(String tag){
        Runtime runtime = Runtime.getRuntime();
        System.out.println("\n"+tag+":");
        System.out.println(runtime.freeMemory()/M+"M(free)/"+runtime.totalMemory()/M+"M(total)");
    }

    public static void main(String[] args) throws InterruptedException {

        /// 例一 ： weakHashMap的key 立马被回收，但是value还在
        /*printlnMemory("1,原可用内存和总内存");

        WeakHashMap<byte[],byte[]> testWeakHashMap = new WeakHashMap<>();
        testWeakHashMap.put(new byte[5*M],new byte[5*M]);
        printlnMemory("2.实例化10M的数组，并放入WeakHashMap后的内存情况");

        // gc后 weakHashMap的 key被 立马回收了，但是value还在！
        System.gc();
        printlnMemory("3.GC后");
        testWeakHashMap.put(new byte[5*M],new byte[5*M]);
        System.out.println("WeakHashMap.get():"+testWeakHashMap);
        */


        /// 例二 ： weakHashMap的key 立马被回收，通过访问public方法（内调用expungeStaleEntries()方法）将value值清理掉
        // 参考：[WeakHashMap的神话](https://www.iteye.com/topic/587995)
        printlnMemory("1,原可用内存和总内存");
        List<WeakHashMap<byte[][], byte[][]>> maps = new ArrayList<WeakHashMap<byte[][], byte[][]>>();

        for (int i = 0; i < 15; i++) {
            WeakHashMap<byte[][], byte[][]> d = new WeakHashMap<byte[][], byte[][]>();
            d.put(new byte[1000][1000], new byte[1000][1000]);
            System.out.println("TWP:"+ RamUsageEstimator.sizeOf(d)); // 2040248
            maps.add(d);
            System.gc();
            System.err.println(i);
            //size()方法内调用了 expungeStaleEntries()方法，可以清理掉value
            for (int j = 0; j < i; j++) {
                System.err.println(j+  " size" + maps.get(j).size());
            }
        }
        printlnMemory("2,一顿操作后，当前内存");

    }
}
