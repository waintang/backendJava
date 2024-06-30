package com.example.practice;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

public class ListTest {
    public static void main(String[] args) {
        List<Long> twps = Arrays.asList(917L);
        List<String> list230808 = new ArrayList<>();
        list230808.add("T");
        list230808.add("W");
        list230808.add("P");
        String[] arr230808 = new String[]{};
        String [] arr23080802 = list230808.toArray(arr230808);
        System.out.println(JSONObject.toJSONString(arr23080802));

        List<String> listNew230629 = Arrays.asList("a","b","c");
        List<String> listExist23062901 = Arrays.asList("a","b");
        List<String> listInsert23062902 = new ArrayList<>(listNew230629);
        listInsert23062902.removeAll(listExist23062901);

        Collections.emptyList().size();

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
