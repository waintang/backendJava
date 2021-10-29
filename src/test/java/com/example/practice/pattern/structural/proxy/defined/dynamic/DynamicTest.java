package com.example.practice.pattern.structural.proxy.defined.dynamic;

import com.example.practice.pattern.structural.proxy.defined.RealSubject;
import com.example.practice.pattern.structural.proxy.defined.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * java的动态代理
 *      基于的反射、接口
 */
public class DynamicTest {
    public static void main(String[] args) {
        Subject realSubject = new RealSubject();
        // 动态代理的 三大参数：被代理类的类加载器、被代理类的接口Class数组、调用处理器
        // 被代理类的 类加载器
        ClassLoader classLoader = RealSubject.class.getClassLoader();
        // 被代理对象的 接口的Class对象数组
        Class<?>[] interfaces = RealSubject.class.getInterfaces();
        // 调用处理器
//        InvocationHandler handler = new DynamicProxy(realSubject);
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                if(methodName == "request"){
                    System.out.println("prrr request.");
                }
                // 犯过的错:此处写proxy 会导致无限循环
                //return method.invoke(proxy,args);
                return method.invoke(realSubject,args);
            }
        };

        Subject dynamicProxy = (Subject)Proxy.newProxyInstance(classLoader,interfaces,handler);

        dynamicProxy.request();
    }
}
