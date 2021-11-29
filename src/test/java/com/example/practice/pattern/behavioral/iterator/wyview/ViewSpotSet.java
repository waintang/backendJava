package com.example.practice.pattern.behavioral.iterator.wyview;

// 1、定义 景点 抽象聚合接口
public interface ViewSpotSet {
    public void add(WyViewSpot wyViewSpot);

    public void remove(WyViewSpot wyViewSpot);

    public ViewSpotIterator getIterator();
}
