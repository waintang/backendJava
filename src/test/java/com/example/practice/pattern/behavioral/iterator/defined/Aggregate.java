package com.example.practice.pattern.behavioral.iterator.defined;

// 抽象聚合 接口
public interface Aggregate {
    public void add(Object obj);

    public void remove(Object obj);

    public Iterator getIterator();
}
