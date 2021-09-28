package com.example.practice.pattern.behavioral.template.advance;

import com.example.practice.pattern.behavioral.template.Cricket;
import com.example.practice.pattern.behavioral.template.Football;
import com.example.practice.pattern.behavioral.template.Game;

public class GameFactory {

    public static Game createGame(int gameSymbol){
        Game game = null;
        GameSymbol symbol = GameSymbol.findByCode(gameSymbol);
        switch(symbol){
            case FOOTBALL:
                game = new Football();
                break;
            case CRICKET:
                game = new Cricket();
                break;
            default:
                throw new RuntimeException("不支持此类型运动："+symbol);
        }
        return game;
    }
}
