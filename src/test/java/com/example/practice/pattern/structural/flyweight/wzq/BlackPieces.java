package com.example.practice.pattern.structural.flyweight.wzq;

// 具体抽象角色
public class BlackPieces implements ChessPieces{
    private static String B = "b";
    @Override
    public void downPieces(Qipan qipan, Point point) {
        qipan.getQipan()[point.getX()][point.getY()] = B;
    }
}
