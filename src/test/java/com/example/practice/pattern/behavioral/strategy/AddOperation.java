package com.example.practice.pattern.behavioral.strategy;

public class AddOperation implements DoubleIntOperation {

    /**
     * 两int加法
     */
    @Override
    public double doStrategy(int num1, int num2) {
        return num1 + num2;
    }
}
