package com.example.practice.pattern.behavioral.template.basic;

import com.example.practice.pattern.behavioral.template.Cricket;
import com.example.practice.pattern.behavioral.template.Football;
import com.example.practice.pattern.behavioral.template.Game;

/**
 * 类似于 正式环境下， spring容器的Controller单实例
 * @Controller
 */
public class TemplateContext {

    /**
     * 类似于 @GetMapping
     * 不同运动/算法
     */
    public void playCricket(){
        Game game = new Cricket();
        game.play();
    }

    public void playFootball(){
        Game game = new Football();
        game.play();
    }

}
