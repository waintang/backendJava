package com.example.practice.dynamicproxy;

import org.springframework.stereotype.Component;

@Component
public class Repository {
    void save(String data) {
        System.out.println("save data: " + data);
    }
}
