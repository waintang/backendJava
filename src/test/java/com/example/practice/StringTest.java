package com.example.practice;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.util.StringUtils;

public class StringTest {
    public static void main(String[] args) {

        String strSub = "wod-我的-自定义合同行12";
        int middleHorizonLineNum = strSub.lastIndexOf("-");
        System.out.println(middleHorizonLineNum);
        System.out.println(strSub.length());
        System.out.println(strSub.substring(0,middleHorizonLineNum));
        System.out.println(strSub.substring(middleHorizonLineNum,strSub.length()));
        System.out.println(strSub.substring(middleHorizonLineNum,strSub.length()).startsWith("-自定义合同行"));

        String[] aArr = ArrayUtils.EMPTY_STRING_ARRAY;
        for(String aaa :aArr){
            System.out.printf(aaa);
        }

        String testSplit = "123";
        String[] testSplitArr = testSplit.split(",");

        System.out.println("***************************斜杠拆分");
        String xiegangStr = "G0 01 / G11 /";
        String[] a = StringUtils.delimitedListToStringArray(xiegangStr.endsWith("/")?xiegangStr.substring(0,xiegangStr.length()-1):xiegangStr,"/");
        System.out.println(a);
        for(String b :a){
            System.out.println(b.trim());
        }

        System.out.println("***************************测试String7前后intern差异");
        String h1=new String("22")+new String("1");//堆 22、1、221，堆-常量池：（jdk6时,22、1两字符串；jdk7时,堆22、1串的引用）
        h1.intern();// 堆221添加给 常量池：（jdk6时，221字符串给常量池；jdk7时，堆221串的引用给常量池）
        String h2="221"; // 此时，常量池有221，于是：h2（jdk6指向常量池221字符串的引用，jdk7借由常量池指向堆221字符串的引用 ）

        System.out.println("h1和h2 引用地址是否相同："+(h1 == h2));//result：jdk6 false；jdk7 true
        System.out.println("h1和h2 值是否相同："+h1.equals(h2));//result：true
        System.out.println("***************************");


        String testStr = "123唐文翩";
        System.out.println("length():"+testStr.length()+"substring:"+testStr.substring(0,5));
        System.out.println("***************************替换/仅保留特定字符");
        String aa = "223 3 #d 的 是个很__  EEE=+";
        aa = aa.replaceAll("[^a-zA-Z0-9\\u4E00-\\u9FA5]", "");  //去除数字，英文，汉字  之外的内容
        System.out.println(aa);  //输出为   2233d的是个很EEE
        aa = "74asdf";
        aa = aa.toLowerCase().replaceAll("[^a-z0-9]", "");  //转小写、去除数字，小写英文之外的内容
        System.out.println(aa);  //输出为   2233d的是个很EEE
//　　    replaceAll("[\\s*|\t|\r|\n]", "");  // 去除所有空格，制表符

    }
}
