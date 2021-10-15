package com.example.practice.pattern.structural.adapter.sdtf.converter;

import com.example.practice.pattern.structural.adapter.sdtf.Computer;
import com.example.practice.pattern.structural.adapter.sdtf.ComputerImpl;
import com.example.practice.pattern.structural.adapter.sdtf.SdCard;
import com.example.practice.pattern.structural.adapter.sdtf.SdCardImpl;

public class Tf2SdTest {
    public static void main(String[] args) {
        Computer computer = new ComputerImpl();

        SdCard sdCard = new SdCardImpl();
        int writeFlag = computer.writeToSd(sdCard,"twpSD");
        System.out.println(computer.readFromSd(sdCard));

        //  以上是直接操作的 SD卡，以下是 操作的 套了卡套转换器的TF卡
        System.out.println("以上是直接操作的 SD卡，以下是 操作的 套了卡套转换器的TF卡");

        SdCard tf2SdCard = new Tf2SdConverter();
        writeFlag = computer.writeToSd(tf2SdCard,"twpTF");
        System.out.println(computer.readFromSd(tf2SdCard));
    }
}
