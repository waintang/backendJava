package com.example.practice;

import java.util.Objects;

public class ObjectTest {
    public static void main(String[] args) {
        Long long1 = 57522L;
        Long long2 = 57522L;
        boolean bool240218 = Objects.equals(long1.toString(),long2.toString());
        System.out.println(bool240218);
    }
}
