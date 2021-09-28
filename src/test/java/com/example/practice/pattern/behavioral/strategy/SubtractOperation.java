package com.example.practice.pattern.behavioral.strategy;

public class SubtractOperation implements DoubleIntOperation {

    /**
     * 两int减法
     */
    @Override
    public double doStrategy(int num1, int num2) {
        return num1 - num2;
    }
}
