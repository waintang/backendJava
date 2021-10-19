package com.example.practice.pattern.structural.bridge.bug.abstractor;

import com.example.practice.pattern.structural.bridge.bug.impl.Color;
import com.example.practice.pattern.structural.bridge.bug.impl.Red;

public class BugTest {
    public static void main(String[] args) {
        Color red = new Red();
        HandBag handBag = new HandBag(red);
        System.out.println(handBag.getName());
    }
}
