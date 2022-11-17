package com.example.practice.web.generic.dto;

public class Generic<T> {
    public String getName1(T t){
        return "getName1:"+t.getClass().getName();
    }
    public <E> String getName2(E t){
        return "getName2:"+t.getClass().getName();
    }
    public <T> String getName3(T t){
        return "getName3:"+t.getClass().getName();
    }
}
