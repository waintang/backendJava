package com.example.practice.juc.excutor;

public class MyTask implements Runnable {
    private final String name;

    public MyTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Task " + name + " is running at " + System.currentTimeMillis());
    }
}