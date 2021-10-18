package com.example.practice.pattern.behavioral.command.defined;

public class ConcreteCommand implements Command {
    private Receiver receiver;

    public ConcreteCommand(){
        // receiver 可以默认，也可以实际调用时指定
        receiver = new Receiver();
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
