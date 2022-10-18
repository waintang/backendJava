package com.example.practice;

import org.apache.commons.collections4.SetUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {
    public static void main(String[] args) {
        Set<String> a = new HashSet<String>();
        Set<String> b = new HashSet<String>();
        a.add("a");
        a.add("a");
        a.add("c");
        b.add("a");
        b.add("b");
        System.out.println(a);
        System.out.println(b);
        Set<String> diffSet = SetUtils.difference(b,a);
        System.out.println(diffSet);
    }
}
