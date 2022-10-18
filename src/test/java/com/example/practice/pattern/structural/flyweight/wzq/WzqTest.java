package com.example.practice.pattern.structural.flyweight.wzq;

import org.apache.commons.lang3.StringUtils;

public class WzqTest {
    static QiLou qiLou = new QiLou();
    static Qipan qipan = new Qipan();
    public static void main(String[] args) {
        System.out.println("第一轮落子：");
        ChessPieces chessPiece1 = qiLou.getChessPiece("w");
        chessPiece1.downPieces(qipan,new Point(4,4));
        ChessPieces chessPiece2 = qiLou.getChessPiece("b");
        chessPiece2.downPieces(qipan,new Point(4,5));
        System.out.println("第二轮落子：");
        chessPiece1 = qiLou.getChessPiece("w");
        chessPiece1.downPieces(qipan,new Point(3,3));
        chessPiece2 = qiLou.getChessPiece("b");
        chessPiece2.downPieces(qipan,new Point(7,10));

        printQipan();
    }

    public static void printQipan(){
        for(int i=0;i<qipan.getQipan().length;i++){
            for(int j=0;j<qipan.getQipan()[0].length;j++){
                System.out.print((StringUtils.isEmpty(qipan.getQipan()[i][j])?"*":qipan.getQipan()[i][j])+" ");
            }
            System.out.println();
        }
    }
}
