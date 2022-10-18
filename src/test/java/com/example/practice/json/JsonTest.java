package com.example.practice.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

/**
 * @description：jsontest
 * @author：tavion
 * @date：2021/7/15 10:04
 */
public class JsonTest {

    public static void main(String[] args) {
        Test test = Test.builder().testStr1("testStr1-Value").testLong1(12L).build();
        JSONObject jsonObj = JSONObject.parseObject(JSONObject.toJSONString(test));

        // {} 转 dto
        JSONObject jsonObjectBlank = JSONObject.parseObject("{}");
        System.out.println(jsonObjectBlank);
        // null
        String jsonStr = JSONObject.toJSONString(null);
        LocalDate localDate = LocalDate.of(2021, 11, 26);
        System.out.println(localDate.toString());
//        Date date = new Date(localDate);
//        System.out.println(date);

        BigDecimal bigDecimal = new BigDecimal(100);
//        BigDecimal.class.getConstructor;

        JSONObject jsonObject= new JSONObject();
        jsonObject.put("status","UPLOAD_SUCESS");
        jsonObject.put("a","A");
        jsonObject.put("b","B");
        jsonObject.put("amount",100);
        String str = JSON.toJSONString(jsonObject);
        System.out.println(str);

        JSON json  =(JSON)JSON.parse("{a:1,b:{c:2,d:null},e:null}");

        String jsonString = JSON.toJSONString(json, SerializerFeature.WriteNonStringKeyAsString);

        List<Map<String,String>> listMap = new ArrayList<>();
        Map<String,String> map1 = new HashMap<>();
        map1.put("createdBy","1410");
        map1.put("contractNumber","1006294");
        Map<String,String> map2 = new HashMap<>();
        map2.put("createdBy","1411");
        map2.put("contractNumber","1006295");
        listMap.add(map1);
        listMap.add(map2);

        JSONArray jsonListArray = (JSONArray) JSON.toJSON(listMap);
        JSONObject json0 = (JSONObject)jsonListArray.get(0);
        JSONObject json1 = (JSONObject)jsonListArray.get(1);
        Object o = json0.remove("createdBy");
        json0.putAll(json1);

        JSONObject jsonObject2= JSON.parseObject("{}");
        JSONArray jsonArray= JSON.parseArray("[]");
        System.out.println("twp:"+jsonObject2.getString("TWP"));
//        System.out.println("twp:"+jsonArray.getJSONObject2(0).getString("TWP"));

        List<String> companyInfos = new ArrayList<>();
        if(companyInfos.stream().noneMatch(item->"twp".equals(item))){
            System.out.println("空集合也通过。");
        }
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    static class Test{
        private String testStr1;
        private String testStr2;
        private Long testLong1;
    }
}
