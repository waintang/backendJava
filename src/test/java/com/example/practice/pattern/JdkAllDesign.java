package com.example.practice.pattern;

import org.junit.platform.commons.logging.LoggerFactory;

import javax.servlet.FilterChain;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Logger;

public class JdkAllDesign {
    public static void main(String[] args) {
        // 1、单例模式
        Runtime runtime = Runtime.getRuntime();

        //2、静态工厂
        Integer.valueOf(1);
        try {
            Class clz = Class.forName("com.example.practice.StringTest");
            for(Method method : clz.getDeclaredMethods()){
                System.out.println("clzName:"+clz.getName()+" method:"+method.getName());
                method.invoke(clz,new String[]{""});
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        // 3、

        // 20 责任链（外部控制、内部节点控制 两种方式/模式 决定是否往下传）
        // 比如 过滤器
        // FilterChain chain = new FilterChain();
        // JDK日志 Logger \ Handler
        Logger logger = Logger.getLogger("log-test");
        logger.warning("warning");

        ClassLoader.getSystemClassLoader();
    }
}
