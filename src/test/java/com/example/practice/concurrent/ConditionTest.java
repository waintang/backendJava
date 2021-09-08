package com.example.practice.concurrent;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @description：Lock后Condition状态
 * @author：tavion
 * @date：2021/6/10 9:25
 */
public class ConditionTest {

    public static void main(String[] args) throws Exception {
        boolean flag = null == new ArrayList();
        System.out.println("flag:"+flag);
        throw new RuntimeException("暂未迁移此功能。");
    }

}
