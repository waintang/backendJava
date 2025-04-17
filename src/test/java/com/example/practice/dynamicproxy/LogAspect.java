package com.example.practice.dynamicproxy;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    // 1. 定义切点（拦截 Service 的所有方法）
//    @Pointcut("execution(* com.example.practice.dynamicproxy.Service.*(..))")
    @Pointcut("execution(* com.example.practice.dynamicproxy.Service.*(..))")
    public void doSomething() {}

    // 2. 前置拦截（子类代理插入逻辑）
    @Before("doSomething()")
    public void logBefore() {
        System.out.println("[AOP] 方法调用前记录日志");
    }

    // 3. 后置拦截
    @AfterReturning("doSomething()")
    public void logAfter() {
        System.out.println("[AOP] 方法执行成功");
    }
}