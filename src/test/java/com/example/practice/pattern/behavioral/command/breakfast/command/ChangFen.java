package com.example.practice.pattern.behavioral.command.breakfast.command;

import com.example.practice.pattern.behavioral.command.breakfast.receiver.ChangFenChef;
import com.example.practice.pattern.behavioral.command.breakfast.receiver.Chef;

public class ChangFen implements Breakfast {
    private Chef chef ;

    public ChangFen(){
        chef = new ChangFenChef();
    }

    @Override
    public void cooking() {
        chef.cooking();
    }
}
