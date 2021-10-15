package com.example.practice.pattern.structural.adapter.sdtf.converter;

import com.example.practice.pattern.structural.adapter.sdtf.SdCard;

/**
 * 适配器的 两种实现模式
 * 1、对象适配器
 * 2、类适配器
 * 拓展：3、双向适配
 */
// 此处是 类适配
/*public class Tf2SdConverter extends TfCardImpl implements SdCard {
    @Override
    public String read() {
        return readTf();
    }

    @Override
    public int write(String msg) {
        return writeTf(msg);
    }
}*/
// 此处是 对象适配
public class Tf2SdConverter implements SdCard {
    TfCard tfCard ;
    public Tf2SdConverter(){
        tfCard = new TfCardImpl();
    }
    @Override
    public String read() {
        return tfCard.readTf();
    }

    @Override
    public int write(String msg) {
        return tfCard.writeTf(msg);
    }
}
