package com.example.practice.pattern.structural.bridge.bag;

import com.example.practice.pattern.structural.bridge.bag.abstractor.HandBag;
import com.example.practice.pattern.structural.bridge.bag.impl.Color;
import com.example.practice.pattern.structural.bridge.bag.impl.Red;

public class BagTest {
    public static void main(String[] args) {
        Color red = new Red();
        HandBag handBag = new HandBag(red);
        System.out.println(handBag.getName());
    }
}
