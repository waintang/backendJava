package com.example.practice.pattern.behavioral.iterator.defined;

import java.util.ArrayList;
import java.util.List;

// 具体聚合 接口
public class ConcreteAggregate implements Aggregate{
    private List<Object> objList = new ArrayList<Object>();
    @Override
    public void add(Object obj) {
        objList.add(obj);
    }

    @Override
    public void remove(Object obj) {
        objList.remove(obj);
    }

    @Override
    public Iterator getIterator() {
        return new ConcreteIterator(objList);
    }
}
