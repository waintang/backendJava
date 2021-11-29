package com.example.practice.pattern.behavioral.visitor.computer;

public class ComputerTest {
    public static void main(String[] args) {
        Computer computer = new Computer();

        computer.accept(new ComputerPartDisplayVisitor());
    }
}
