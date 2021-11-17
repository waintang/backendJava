package com.example.practice.java8.thread;

import java.lang.ref.WeakReference;

public class WeakReferenceTest {
    public static int M = 1024*1024;

    public static void printlnMemory(String tag){
        Runtime runtime = Runtime.getRuntime();
        System.out.println("\n"+tag+":");
        System.out.println(runtime.freeMemory()/M+"M(free)/"+runtime.totalMemory()/M+"M(total)");
    }

    public static void main(String[] args) {
        printlnMemory("1,原可用内存和总内存：");

        //这句是 强引用，gc不能回收！
//        byte[] strongReference = new byte[10*M];
        WeakReference<byte[]> weakReference = new WeakReference<>(new byte[10*M]);
        printlnMemory("2.实例化10M的数组，并放入WeakHashMap后的内存情况：");
        System.out.println("weakReference.get():"+weakReference.get());

        System.gc();
        printlnMemory("3.GC后");
        System.out.println("weakReference.get():"+weakReference.get());

    }
}
