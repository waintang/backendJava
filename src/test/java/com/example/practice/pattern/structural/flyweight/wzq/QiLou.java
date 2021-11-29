package com.example.practice.pattern.structural.flyweight.wzq;

import java.util.ArrayList;

// 享元工厂 - 棋子颜色是 享元的
public class QiLou {
    private ArrayList<ChessPieces> qz;
    public QiLou(){
        qz = new ArrayList<>();
        ChessPieces w = new WhitePieces();
        qz.add(w);
        ChessPieces b = new BlackPieces();
        qz.add(b);
    }

    public ChessPieces getChessPiece(String type){
        if("w".equals(type)){
            return qz.get(0);
        }
        return qz.get(1);
    }
}
