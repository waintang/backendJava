package com.example.practice.pattern.behavioral.strategy.basic;

import com.alibaba.fastjson.JSON;
import com.example.practice.pattern.behavioral.strategy.DoubleIntOperation;

/**
 * 上下文类（生产环境下，一般指 Spring容器的Controller单例类）
 *      此处 手动new 各个策略类
 *      暂不模拟Controller的autowire工厂模式、单例模式 自动注入
 */
public class Context {

    private DoubleIntOperation doubleIntOperation;

    public Context(DoubleIntOperation doubleIntOperation){
        this.doubleIntOperation = doubleIntOperation;
    }

    /**
     *  @RequestMapping 生产环境 可能是这样用的
    */
    public Object executeContext(/*@PathVariable()*/long userId){
        // query db
        // User user = serviceMapper.search(userId);
        double result = doubleIntOperation.doStrategy(3,2);
        return JSON.parse("[{'UserId':"+userId+",'result':"+result+"}]");
    }

}
