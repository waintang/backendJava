package com.example.practice.pattern.behavioral.command.breakfast.command;

import com.example.practice.pattern.behavioral.command.breakfast.receiver.Chef;
import com.example.practice.pattern.behavioral.command.breakfast.receiver.HeFenChef;

public class HeFen implements Breakfast {
    private Chef chef;

    public HeFen(){
        chef = new HeFenChef();
    }

    public void cooking(){
        chef.cooking();
    }

}
