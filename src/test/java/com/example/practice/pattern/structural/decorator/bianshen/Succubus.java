package com.example.practice.pattern.structural.decorator.bianshen;

public class Succubus extends Changer {
    public Succubus(Morrigan morrigan) {
        super(morrigan);
    }

    @Override
    public void display() {
        super.display();
        succubusDecorate();
    }

    private void succubusDecorate(){
        System.out.println("变身女妖");
    }
}
