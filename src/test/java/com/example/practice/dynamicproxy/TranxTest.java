package com.example.practice.dynamicproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TranxTest {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TranxTest.class);
        Service service = context.getBean(Service.class);
        service.doSomething();
    }
}
