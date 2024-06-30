package com.example.practice;

import com.alibaba.fastjson.JSONObject;

public class LongTest {
    public static void main(String[] args) {
        Long long230627 = 461550926101090304L;
        Boolean flag230412 = Integer.valueOf(1).equals(null);
        Long testStr1 = new Long("123");
        System.out.println("testStr1:"+testStr1);
        Long testStr2 = new Long("文青青");
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
