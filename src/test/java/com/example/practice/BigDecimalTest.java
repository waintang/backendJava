package com.example.practice;

import cn.hutool.core.math.MathUtil;
import com.example.practice.utils.NumberToCN;

import java.math.BigDecimal;

public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal bg23101201 = new BigDecimal("12.1");
        BigDecimal bg23101202 = new BigDecimal("12.10");
        BigDecimal bg23101203 = new BigDecimal(12.1);
        BigDecimal bg23101204 = new BigDecimal(12.10);
        // 创建
        // 对比
        Boolean bool23101201 = bg23101201.equals(bg23101202);
        int int23101201 = bg23101201.compareTo(bg23101202);

        Boolean bool23101202 = bg23101203.equals(bg23101204);
        int int23101202 = bg23101203.compareTo(bg23101204);
        // 展示
        // 存储用decimal
        String numberStr = NumberToCN.number2CNMontrayUnit("12.3456");
//        new BigDecimal("2021/01/03");
//        ccrtPaySettDto.getPlanAmount().compareTo(tax.add(feeWithoutTax)) != 0
        int compareResult = BigDecimal.ONE.compareTo(BigDecimal.ZERO);

        BigDecimal item = new BigDecimal("12.167");
        BigDecimal item2= item.setScale(1, BigDecimal.ROUND_DOWN);
        System.out.println(item+"前后"+item2);


        BigDecimal result = BigDecimal.valueOf(123.234522).divide(BigDecimal.ONE,BigDecimal.ROUND_CEILING);
        BigDecimal result2 = BigDecimal.valueOf(123.2345).subtract(BigDecimal.valueOf(38)).divide(BigDecimal.valueOf(350),2,BigDecimal.ROUND_CEILING);
        System.out.println(result);
        System.out.println(result2);
    }
}
