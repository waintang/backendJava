package com.example.practice.pattern.behavioral.strategy;

/**
 * 两int乘法
 */
public class MutiplyOperation implements DoubleIntOperation {
    @Override
    public double doStrategy(int num1, int num2) {
        return num1 * num2;
    }
}
