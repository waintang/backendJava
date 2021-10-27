package com.example.practice.pattern.behavioral.template.defined;

public class DefinedTest {
    public static void main(String[] args) {
        AbstractClass abstractClass = new ConcreteClass();
        abstractClass.templateMethod();
    }
}
