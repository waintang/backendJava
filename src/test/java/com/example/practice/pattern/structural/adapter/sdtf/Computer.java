package com.example.practice.pattern.structural.adapter.sdtf;

public interface Computer {
    String readFromSd(SdCard sdCard);
    int writeToSd(SdCard sdCard,String msg);
}
