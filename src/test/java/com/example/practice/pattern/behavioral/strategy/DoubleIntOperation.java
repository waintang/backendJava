package com.example.practice.pattern.behavioral.strategy;

/**
 * 两个int类型操作（不是啥都能处理的）
 */
public interface DoubleIntOperation {
    String addSymbol = "+";
    String subtractSymbol = "-";
    String mutiplySymbol = "*";
    String divideSymbol = "/";
    public double doStrategy(int num1 ,int num2);
}