package com.example.practice.pattern.behavioral.command.breakfast.invoker;

import com.example.practice.pattern.behavioral.command.breakfast.command.Breakfast;

import java.util.ArrayList;
import java.util.List;

public class Waiter2 {
    private List<Breakfast> breakfastList = new ArrayList<>();

    public void addBreakfast(Breakfast breakfast){
        breakfastList.add(breakfast);
    }

    public void confirmAndOrder(){
        for(Breakfast breakfast : breakfastList){
            breakfast.cooking();
        }
    }

}
