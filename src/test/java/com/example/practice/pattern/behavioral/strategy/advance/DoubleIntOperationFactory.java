package com.example.practice.pattern.behavioral.strategy.advance;

import com.example.practice.pattern.behavioral.strategy.*;

/**
 * 工厂模式
 */
public class DoubleIntOperationFactory {

    public static DoubleIntOperation getInstance(String symbol){
        DoubleIntOperation doubleIntOperation = null;
        switch (symbol) {
            case DoubleIntOperation.addSymbol:
                doubleIntOperation = new AddOperation();
                break;
            case DoubleIntOperation.subtractSymbol:
                doubleIntOperation = new SubtractOperation();
                break;
            case DoubleIntOperation.mutiplySymbol:
                doubleIntOperation = new MutiplyOperation();
                break;
            case DoubleIntOperation.divideSymbol:
                doubleIntOperation = new DivideOperation();
                break;
            default:
                doubleIntOperation = new AddOperation();
        }
        return doubleIntOperation;
    }
}
