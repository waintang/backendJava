package com.example.practice.pattern.creational.builder.material;

public abstract class Burger implements Item {

    @Override
    public Packing packing(){
        return new Wrapper();
    }

}
