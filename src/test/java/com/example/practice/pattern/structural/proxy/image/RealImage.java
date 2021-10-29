package com.example.practice.pattern.structural.proxy.image;

public class RealImage implements Image {
    private String fileName ;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }
    @Override
    public void display() {
        System.out.println("display " +fileName);
    }

    private void loadFromDisk(String fileName){
        System.out.println("loading " +fileName+" from disk");
    }
}
