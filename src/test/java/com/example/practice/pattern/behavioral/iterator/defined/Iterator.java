package com.example.practice.pattern.behavioral.iterator.defined;

// 抽象 迭代器
public interface Iterator {
    Object first();
    Object next();
    boolean hasNext();
}
