package com.example.practice.pattern.behavioral.visitor.made;

public class MadeTest {
    public static void main(String[] args) {
        SetMaterial setMaterial = new SetMaterial();
        setMaterial.add(new Paper());
        setMaterial.add(new Cuprum());

        System.out.println(setMaterial.accept(new ArtCompany()));
        System.out.println(setMaterial.accept(new Mint()));
    }
}
