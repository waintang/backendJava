package com.example.practice.pattern.structural.adapter.sdtf;

public class SdTest {
    public static void main(String[] args) {
        SdCard sdCard = new SdCardImpl();
        Computer computer = new ComputerImpl();
        int writeFlag = computer.writeToSd(sdCard,"twp");
        System.out.println(computer.readFromSd(sdCard));
    }
}
