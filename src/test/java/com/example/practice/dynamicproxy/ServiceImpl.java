package com.example.practice.dynamicproxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    @Autowired
    public Repository repository;

//    @Transactional
    @Override
    public  void doSomething() {
        System.out.println("ServiceImpl.doSomething");
        repository.save("data");
    }

}
