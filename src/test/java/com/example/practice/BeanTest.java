package com.example.practice;

import cn.hutool.core.util.ObjectUtil;
import lombok.Builder;
import lombok.Data;

public class BeanTest {
    public static void main(String[] args) {
        Boolean equalFlag =  ObjectUtil.equal(Twp.builder().str("tfwp").build(),Twp.builder().str("twp").build());
        System.out.println("===equalFlag:"+equalFlag);
    }

    @Data
    @Builder
    public static class Twp {
        private String str ;
        private Long aLong;
        private int anInt;
    }
}
