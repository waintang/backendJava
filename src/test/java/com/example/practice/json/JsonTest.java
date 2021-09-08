package com.example.practice.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @description：jsontest
 * @author：tavion
 * @date：2021/7/15 10:04
 */
public class JsonTest {

    public static void main(String[] args) {

        JSONObject jsonObject= JSON.parseObject("{}");
        JSONArray jsonArray= JSON.parseArray("[]");
        System.out.println("twp:"+jsonObject.getString("TWP"));
//        System.out.println("twp:"+jsonArray.getJSONObject(0).getString("TWP"));

        List<String> companyInfos = new ArrayList<>();
        if(companyInfos.stream().noneMatch(item->"twp".equals(item))){
            System.out.println("空集合也通过。");
        }
    }
}
