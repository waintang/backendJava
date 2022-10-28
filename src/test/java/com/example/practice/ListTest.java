package com.example.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
//        List<String> testStrList = null;
        List<String> testStrList = new ArrayList<>();
        testStrList.add("abc");
        Iterator<String> iterator = testStrList.iterator();
        if(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        for(String str :testStrList){
            System.out.println("str");
        }
    }
}
