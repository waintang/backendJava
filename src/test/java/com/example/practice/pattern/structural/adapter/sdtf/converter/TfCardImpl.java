package com.example.practice.pattern.structural.adapter.sdtf.converter;

public class TfCardImpl implements TfCard {
    private StringBuilder storeData = new StringBuilder();
    @Override
    public String readTf() {
        return storeData.toString();
    }

    @Override
    public int writeTf(String msg) {
        storeData.append(msg);
        return 1;
    }
}
