package com.example.practice.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.Servlet;

/**
 * AnnotationConfigApplicationContext 实现基于Java的配置类加载Spring的应用上下文。避免使用application.xml进行配置。相比XML配置，更加便捷。
 *
 * @author twp
 * @date 2020/01/19
 */
public class JavaConfigTest {

    public static void main(String[] arg) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();

        Entitlement ent = (Entitlement)ctx.getBean("entitlement");
        System.out.println(ent.getName());
        System.out.println(ent.getTime());

        Entitlement ent2 = (Entitlement)ctx.getBean("entitlement2");
        System.out.println(ent2.getName());
        System.out.println(ent2.getTime());
        ctx.close();
    }
}
