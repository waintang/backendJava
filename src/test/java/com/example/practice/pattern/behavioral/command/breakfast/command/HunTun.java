package com.example.practice.pattern.behavioral.command.breakfast.command;

import com.example.practice.pattern.behavioral.command.breakfast.receiver.Chef;
import com.example.practice.pattern.behavioral.command.breakfast.receiver.HunTunChef;

public class HunTun implements Breakfast {
    private Chef chef;

    public HunTun(){
        this.chef = new HunTunChef();
    }

    @Override
    public void cooking() {
        chef.cooking();
    }
}
