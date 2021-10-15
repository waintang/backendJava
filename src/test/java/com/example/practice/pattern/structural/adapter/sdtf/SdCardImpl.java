package com.example.practice.pattern.structural.adapter.sdtf;

public class SdCardImpl implements SdCard {
    private StringBuilder storeData = new StringBuilder();
    @Override
    public String read() {
        return storeData.toString();
    }

    @Override
    public int write(String msg) {
        storeData.append(msg);
        return 1;
    }
}
