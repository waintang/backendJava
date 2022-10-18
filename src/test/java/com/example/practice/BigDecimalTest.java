package com.example.practice;

import cn.hutool.core.math.MathUtil;

import java.math.BigDecimal;

public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal item = new BigDecimal("12.167");
        BigDecimal item2= item.setScale(1, BigDecimal.ROUND_DOWN);
        System.out.println(item+"前后"+item2);


        BigDecimal result = BigDecimal.valueOf(123.234522).divide(BigDecimal.ONE,BigDecimal.ROUND_CEILING);
        BigDecimal result2 = BigDecimal.valueOf(123.2345).subtract(BigDecimal.valueOf(38)).divide(BigDecimal.valueOf(350),2,BigDecimal.ROUND_CEILING);
        System.out.println(result);
        System.out.println(result2);
    }
}
