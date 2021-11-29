package com.example.practice.pattern.behavioral.iterator.defined;

import java.util.List;

// 具体 迭代器
public class ConcreteIterator implements Iterator{
    private List<Object> list = null;

    private int index = -1;

    public ConcreteIterator(List<Object> objList){
        this.list = objList;
    }

    @Override
    public Object first() {
        index = 0;
        return this.list.get(index);
    }

    @Override
    public Object next() {
        Object obj = null;
        if(hasNext()){
            obj = list.get(++index);
        }
        return obj;
    }

    @Override
    public boolean hasNext() {
        if(index < list.size()-1){
            return true;
        }
        return false;
    }
}
