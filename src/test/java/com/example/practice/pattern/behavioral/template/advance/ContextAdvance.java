package com.example.practice.pattern.behavioral.template.advance;

import com.example.practice.pattern.behavioral.template.Cricket;
import com.example.practice.pattern.behavioral.template.Football;
import com.example.practice.pattern.behavioral.template.Game;

/**
 * 类似于 正式环境下， spring容器的Controller单实例
 * @Controller
 */
public class ContextAdvance {

    /**
     * 类似于 @GetMapping
     * 不同运动/算法
     */
    public void playCricket(){
//        Game game = new Cricket(); // 改成 工厂模式
        Game game = GameFactory.createGame(GameSymbol.CRICKET.code);
        game.play();
    }

    public void playFootball(){
//        Game game = new Football();
        Game game = GameFactory.createGame(GameSymbol.FOOTBALL.code);
        game.play();
    }
}
