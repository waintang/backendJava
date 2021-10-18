package com.example.practice.pattern.behavioral.command.defined;

public class DefinedTest {
    public static void main(String[] args) {
        Command command = new ConcreteCommand();
        Invoker invoker = new Invoker(command);
        invoker.call();
    }
}
