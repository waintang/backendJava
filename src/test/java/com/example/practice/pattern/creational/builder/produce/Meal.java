package com.example.practice.pattern.creational.builder.produce;

import com.example.practice.pattern.creational.builder.material.Item;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    List<Item> items = new ArrayList();

    public void addItem(Item item){
        items.add(item);
    }

    public float getCost(){
        float cost = 0f;
        for(Item item:items){
            cost+=item.price();
        }
        return cost;
    }

    public void printItems(){
        for(Item item:items){
            System.out.print("Item:"+item.name());
            System.out.print(" Price:"+item.price());
            System.out.print(" Packing:"+item.packing());
            System.out.println("");
        }
    }
}
