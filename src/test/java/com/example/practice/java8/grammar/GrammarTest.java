package com.example.practice.java8.grammar;

public class GrammarTest {
    public static void main(String[] args) {
        Boolean testNull = null;
        if(testNull && true){ // null 直接抛 空指针
            System.out.println("null被识别成true");
        }else{
            System.out.println("null被识别成false");
        }
    }
}
