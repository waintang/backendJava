package com.example.practice.pattern.behavioral.command.defined;

public class Invoker {
    private Command command;

    public Invoker(Command command){
        this.command = command;
    }

    public void call(){
        command.execute();
    }
}
