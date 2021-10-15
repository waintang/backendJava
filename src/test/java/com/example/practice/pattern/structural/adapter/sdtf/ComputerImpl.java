package com.example.practice.pattern.structural.adapter.sdtf;

public class ComputerImpl implements Computer {
    @Override
    public String readFromSd(SdCard sdCard) {
        return sdCard.read();
    }

    @Override
    public int writeToSd(SdCard sdCard, String msg) {
        return sdCard.write(msg);
    }
}
