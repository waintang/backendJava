package com.example.practice.java8.stream;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapReduceTest {
    public static void main(String[] args) {
        Map<String,String> a = new HashMap<String,String >();
        Map<String,String> b = new HashMap<String,String >();
        a.put("a","A");
        b.put("a","A");
//        b.put("b","B");
        Map<String,String> c = Stream.of(a,b).map(Map::entrySet).flatMap(Collection::stream).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
    }
}
