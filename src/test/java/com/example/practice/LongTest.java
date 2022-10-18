package com.example.practice;

import com.alibaba.fastjson.JSONObject;

public class LongTest {
    public static void main(String[] args) {
        Long a = 1234567l;
        Long b = a ;
        Long c = 1234567l;
        Long d = Long.valueOf(a+"");
        Object obj = 1234567l;
        a = (Long)obj;
        System.out.println("===="+a.equals(b));
        new Long("广日物流（昆山）有限公司");
    }
}
