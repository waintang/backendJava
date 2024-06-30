package com.example.practice;

import com.alibaba.fastjson.JSONObject;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {
    public static void main(String[] args) {

        Map map = new HashMap();
        if (map == null) System.out.println("TWP");
        AbstractMap abstractMap = null;
        // 线程不安全，key/value均可为null
        HashMap hashMap = null;
        // 线程不安全，key不可为空/value可为null
        TreeMap treeMap = null;
        // 线程安全，key/value均不可为null
        ConcurrentHashMap concurrentHashMap = null;
        // 线程安全，key/value均不可为null
        Hashtable hashtable = null;

        // #############################
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("1");
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("1");

        // #############################
        Queue<String> queue = new LinkedList<>();
        //
        Map<String, String> map2Json = new HashMap<>();
        map2Json.put("contractImportKey", "base:batch-import:506:1664365946067");
        System.out.println(JSONObject.toJSONString(map2Json));
    }
}
