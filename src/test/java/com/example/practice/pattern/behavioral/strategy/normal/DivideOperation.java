package com.example.practice.pattern.behavioral.strategy.normal;

/**
 * 两int除法
 */
public class DivideOperation implements DoubleIntOperation {

    @Override
    public double doStrategy(int num1, int num2) {
        return (double)num1 / num2;
    }
}
