package com.example.practice.pattern.structural.proxy.defined.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {
    private Object object;
    public DynamicProxy(Object object){
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        if(methodName == "request"){
            System.out.println("pree request");
            return method.invoke(object,args);
        }
        return null;
    }

}
