package com.example.practice.pattern.behavioral.iterator.wyview;

// 2、定义 景点 迭代接口
public interface ViewSpotIterator {
    WyViewSpot first();
    WyViewSpot next();
    boolean hasNext();
}
