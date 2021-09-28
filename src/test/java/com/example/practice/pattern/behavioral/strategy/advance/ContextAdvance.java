package com.example.practice.pattern.behavioral.strategy.advance;

import com.alibaba.fastjson.JSON;

/**
 * 上下文类（生产环境下，一般指 Spring容器的Controller单例类）
 */
public class ContextAdvance {

    /**
     *  @RequestMapping 生产环境 可能是这样用的
     */
    public Object executeContext(/*@PathVariable()*/long userId,String symbol){
        // query db
        // User user = serviceMapper.search(userId);
        double result = DoubleIntOperationFactory.getInstance(symbol).doStrategy(3,2);
        return JSON.parse("[{'UserId':"+userId+",'result':"+result+"}]");
    }
}
