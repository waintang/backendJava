package com.example.practice.pattern.behavioral.template.advance;

import org.springframework.security.core.parameters.P;

public enum GameSymbol {
    FOOTBALL(1),
    CRICKET(2);

    int code;

    GameSymbol(int code){
        this.code = code;
    }

    public int getGameSymbolCode(){
        return this.code;
    }

    public static GameSymbol findByCode(int code){
        for(GameSymbol symbol : GameSymbol.values()){
            if(symbol.code == code){
                return symbol;
            }
        }
        throw new RuntimeException("不支持此类型运动："+code);
    }
}
