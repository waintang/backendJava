package com.example.practice.algorithm;

import org.apache.commons.lang3.ArrayUtils;

import java.util.*;

public class StringTest {
    public static void main(String[] args) {
        List<String> matchStrList = findSubStr2("xabxabbxbb","abb","b");
        System.out.println(matchStrList.toString());
    }

    /**
     * 字符串中，包含指定首尾 的子字符串
     * @param str 字符串
     * @param pre 指定首
     * @param post 指定尾
     * @return
     */
    static List<String> findSubStr2(String str ,String pre ,String post){
        List<String> matchStr = new ArrayList();

        char[] strArr = str.toCharArray();
        Set<Integer> matchPreIndex = new TreeSet<Integer>();
        Set<Integer> matchPostIndex = new TreeSet<Integer>();

        int strLen = str.length();
        int preLen = pre.length();
        int postLen = post.length();
        boolean flag = false;
        int startIndex = 0;
        for(int i=0; i<= strLen ; i++){
            if(i<=strLen-preLen){
                char[] preTemp = ArrayUtils.subarray(strArr,i,i+preLen);
                String preTempStr = new String(preTemp);
                if(preTempStr.equals(pre)){
                    flag = true;
                    startIndex = i;
                    matchPreIndex.add(i);
                }
            }
            if(i<=strLen-postLen && i>=startIndex+preLen-postLen && flag){
                char[] postTemp = ArrayUtils.subarray(strArr,i,i+postLen);
                String postTempStr = new String(postTemp);
                if(postTempStr.equals(post)){
                    char[] matchTemp = ArrayUtils.subarray(strArr,i,i+postLen);
                    matchPostIndex.add(i);
                }
            }
        }
        System.out.println(matchPreIndex);
        System.out.println(matchPostIndex);

        for(Integer start:matchPreIndex){
            for(Integer end:matchPostIndex){
                if(end>=start+preLen-postLen){
                    char[] postTemp = ArrayUtils.subarray(strArr,start,end+postLen);
                    String matchTempStr = new String(postTemp);
                    matchStr.add(matchTempStr);
                }
            }
        }
        return matchStr;
    }

    static List<String> findSubStr1(String str ,String pre ,String post){
        List<String> matchStr = new ArrayList();

        char[] strArr = str.toCharArray();
//        char[] t = ArrayUtils.subarray(strArr,1,2);
//        System.out.println(new String(t));

        int strLen = str.length();
        int preLen = pre.length();
        int postLen = post.length();
        for(int i=0; i<= strLen-preLen ; i++){
            char[] preTemp = ArrayUtils.subarray(strArr,i,i+preLen);
            String preTempStr = new String(preTemp);
            if(preTempStr.equals(pre)){
                for(int j=i+preLen-postLen;j<=strLen-postLen;j++){
                    char[] postTemp = ArrayUtils.subarray(strArr,j,j+postLen);
                    String postTempStr = new String(postTemp);
                    if(postTempStr.equals(post)){
                        char[] matchTemp = ArrayUtils.subarray(strArr,i,j+postLen);
                        matchStr.add(new String(matchTemp));
                    }
                }
            }
        }
        return matchStr;


        // java自带的
//        return str.substring(str.indexOf(pre),str.indexOf(post)+1);
//        System.out.println(str.indexOf(pre));
//        System.out.println(str.indexOf(post)+1);
//        System.out.println(Pattern.matches(".*abb.*bb.*",str));
//        System.out.println(str.matches("abb.*bb"));
    }
}
