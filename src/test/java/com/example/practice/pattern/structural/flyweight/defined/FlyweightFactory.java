package com.example.practice.pattern.structural.flyweight.defined;

import java.util.HashMap;

public class FlyweightFactory {
    private HashMap<String,Flyweight> flyweightHashMap = new HashMap<>();

    public Flyweight getFlyweight(String key){
        Flyweight flyweight = flyweightHashMap.get(key);
        if(flyweight != null){
            System.out.println("具体享元"+key+"已经存在，被成功获取！");
        }else{
            flyweight = new ConcreteFlyweight(key);
            flyweightHashMap.put(key,flyweight);
        }
        return flyweight;
    }
}
