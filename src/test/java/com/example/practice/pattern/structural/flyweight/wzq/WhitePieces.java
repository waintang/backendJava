package com.example.practice.pattern.structural.flyweight.wzq;

import com.sun.istack.internal.NotNull;

// 具体抽象角色
public class WhitePieces implements ChessPieces{
    private static String W = "w";
    @Override
    public void downPieces(Qipan  qipan, Point point) {
        qipan.getQipan()[point.getX()][point.getY()] = W;
    }
}
