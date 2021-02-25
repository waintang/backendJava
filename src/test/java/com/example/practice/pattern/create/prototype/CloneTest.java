package com.example.practice.pattern.create.prototype;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;

/**
 * 类名 CloneTest
 * 描述 克隆测试类
 */
public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 准备
        AccountDetail detail = new AccountDetail(1L, "1094790168@qq.com");
        Account account = new Account(1L, "tavion", detail);
        // 一、浅克隆证明
        Account clone = (Account) account.clone();
        // 判断详情对对象是否相同，预期值(true)
        System.out.println(clone.getDetail() == account.getDetail());

        // 二、深克隆 之 调用包 fastJson、BeanUtils.copyProperties
        // fastJson实现克隆
        Account cloneDeep = JSONObject.parseObject(JSONObject.toJSONBytes(account), Account.class);
        System.out.println(cloneDeep.getDetail() == account.getDetail());
        // BeanUtils.copyProperties
        Account cloneDeep2 = new Account();
        BeanUtils.copyProperties(clone,cloneDeep2);
        System.out.println(cloneDeep2.getDetail() == account.getDetail());

        // 三、深克隆 之 克隆流
        Account cloneDeep3 = (Account)account.clone();
        System.out.println(cloneDeep3.getDetail() == account.getDetail());

    }
}