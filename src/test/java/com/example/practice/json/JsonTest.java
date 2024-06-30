package com.example.practice.json;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @description：jsontest
 * @author：tavion
 * @date：2021/7/15 10:04
 */
public class JsonTest {

    public static void main(String[] args) {
        String jsonStr240219 = "{null:\"employee\",\"1\":\"employeeid2\"}";
        JSONObject jsonObject240219 = JSONObject.parseObject(jsonStr240219);

        String jsonStr230612 = "{\"testLong1\":\"12sdsf\",\"test\":\"12\"}";
        String jsonStr240605 = "{\"test\":\"12\",\"bool1\":\"true\",\"innerTest2s\":[{\"innerStr1\":\"inner\"}]}";
        String jsonStr24060502 = "{\"test\":\"12\",\"bool1\":\"true\",\"innerTest2s\":\"sdfsf\"}";
        JSONObject jsonObj240605 = JSONObject.parseObject(jsonStr240605);
        Long testLong1 = jsonObj240605.getLong("testLong1");
        Test2<String> json230612 = JSON.parseObject(jsonStr240605,new TypeReference<Test2<String>>(){});

        List<Test> testList230331 = new ArrayList<>();
        testList230331.add(Test.builder().date1(new Date()).localDate1(LocalDate.now()).testLong1(11L).build());
        String listStr230331 = JSONObject.toJSONString(testList230331,SerializerFeature.WriteDateUseDateFormat);//
        System.out.println(listStr230331);

        String testStr = "abc";
        String testJson = "{'name':'abc'}";
        String testJsonArr = "[{'name':'abc'}]";
        Boolean jsonObj230223 = JSONUtil.isJsonObj(testStr);
        jsonObj230223 = JSONUtil.isJsonObj(testJson);
        jsonObj230223 = JSONUtil.isJsonArray(testJson);
        jsonObj230223 = JSONUtil.isJsonObj(testJsonArr);
         jsonObj230223 = JSONUtil.isJsonArray(testJsonArr);
        JSONObject json2 = JSONObject.parseObject("{\"error\":false,\"fieldCode\":\"taxRate\",\"fieldName\":\"兑本位币汇率\",\"fieldValue\":\"\",\"requiredFlag\":false,\"tenantId\":481}");
        Object fieldValue = json2.get("fieldValue");
        JSONArray json2StrJsonArray = JSONObject.parseArray("[{\"enabledFlag\":1,\"meaning\":\"完美日记-中国台湾\",\"orderSeq\":1,\"value\":\"1\"},{\"enabledFlag\":1,\"meaning\":\"完美日记-菲律宾\",\"orderSeq\":2,\"value\":\"2\"},{\"enabledFlag\":1,\"meaning\":\"完美日记-泰国\",\"orderSeq\":3,\"value\":\"3\"},{\"enabledFlag\":1,\"meaning\":\"完美日记-新加坡\",\"orderSeq\":4,\"value\":\"4\"},{\"enabledFlag\":1,\"meaning\":\"完美日记-马来西亚\",\"orderSeq\":5,\"value\":\"5\"},{\"enabledFlag\":1,\"meaning\":\"完美日记-越南\",\"orderSeq\":6,\"value\":\"6\"},{\"enabledFlag\":1,\"meaning\":\"完美日记-印尼特区\",\"orderSeq\":7,\"value\":\"7\"},{\"enabledFlag\":1,\"meaning\":\"polibeli\",\"orderSeq\":8,\"value\":\"8\"},{\"enabledFlag\":1,\"meaning\":\"娇恩浓-安满JD\",\"orderSeq\":9,\"value\":\"9\"},{\"enabledFlag\":1,\"meaning\":\"meego项目\",\"orderSeq\":10,\"value\":\"10\"},{\"enabledFlag\":1,\"meaning\":\"聚宏迦-绿盛\",\"orderSeq\":11,\"value\":\"11\"},{\"enabledFlag\":1,\"meaning\":\"完美日记项目G-PJ-202205-001\",\"orderSeq\":12,\"value\":\"12\"},{\"enabledFlag\":1,\"meaning\":\"成都壹号魔方仓\",\"orderSeq\":13,\"value\":\"13\"},{\"enabledFlag\":1,\"meaning\":\"娇恩浓-炒货\",\"orderSeq\":14,\"value\":\"14\"},{\"enabledFlag\":1,\"meaning\":\"一般贸易仓-仓一号\",\"orderSeq\":15,\"value\":\"15\"},{\"enabledFlag\":1,\"meaning\":\"一般贸易仓-富辰运项目\",\"orderSeq\":16,\"value\":\"16\"},{\"enabledFlag\":1,\"meaning\":\"一般贸易仓-仓管家项目\",\"orderSeq\":17,\"value\":\"17\"},{\"enabledFlag\":1,\"meaning\":\"品牌市场推广\",\"orderSeq\":18,\"value\":\"18\"},{\"enabledFlag\":1,\"meaning\":\"慧源通义乌仓-P-PJ-202204-03\",\"orderSeq\":19,\"value\":\"19\"},{\"enabledFlag\":1,\"meaning\":\"慧源通温州仓-P-PJ-202204-02\",\"orderSeq\":20,\"value\":\"20\"},{\"enabledFlag\":1,\"meaning\":\"慧源通宝鸡仓-P-PJ-202204-01\",\"orderSeq\":21,\"value\":\"21\"},{\"enabledFlag\":1,\"meaning\":\"娇恩浓-宠粮\",\"orderSeq\":22,\"value\":\"22\"},{\"enabledFlag\":1,\"meaning\":\"聚宏迦-美妆\",\"orderSeq\":23,\"value\":\"23\"},{\"enabledFlag\":1,\"meaning\":\"聚宏迦-好丽友\",\"orderSeq\":24,\"value\":\"24\"},{\"enabledFlag\":1,\"meaning\":\"品牌孵化中心-vitalbeautie\",\"orderSeq\":25,\"value\":\"25\"},{\"enabledFlag\":1,\"meaning\":\"CBG出口操作业务团队\",\"orderSeq\":26,\"value\":\"26\"},{\"enabledFlag\":1,\"meaning\":\"GBG-出口项目\",\"orderSeq\":27,\"value\":\"27\"},{\"enabledFlag\":1,\"meaning\":\"CBG-出口项目\",\"orderSeq\":28,\"value\":\"28\"},{\"enabledFlag\":1,\"meaning\":\"跨境业务团队-出口\",\"orderSeq\":29,\"value\":\"29\"},{\"enabledFlag\":1,\"meaning\":\"聚宏迦-安满\",\"orderSeq\":30,\"value\":\"30\"},{\"enabledFlag\":1,\"meaning\":\"娇恩浓-药品POP\",\"orderSeq\":31,\"value\":\"31\"},{\"enabledFlag\":1,\"meaning\":\"娇恩浓-美妆POP\",\"orderSeq\":32,\"value\":\"32\"},{\"enabledFlag\":1,\"meaning\":\"娇恩浓-香缇卡\",\"orderSeq\":33,\"value\":\"33\"},{\"enabledFlag\":1,\"meaning\":\"娇恩浓-酒水\",\"orderSeq\":34,\"value\":\"34\"},{\"enabledFlag\":1,\"meaning\":\"品牌孵化中心-乐天然\",\"orderSeq\":35,\"value\":\"35\"},{\"enabledFlag\":1,\"meaning\":\"品牌孵化中心-时分新鲜\",\"orderSeq\":36,\"value\":\"36\"},{\"enabledFlag\":1,\"meaning\":\"行云货仓\",\"orderSeq\":37,\"value\":\"37\"},{\"enabledFlag\":1,\"meaning\":\"Grafen\",\"orderSeq\":38,\"value\":\"38\"},{\"enabledFlag\":1,\"meaning\":\"puttisu \",\"orderSeq\":39,\"value\":\"39\"},{\"enabledFlag\":1,\"meaning\":\"缇纷\",\"orderSeq\":40,\"value\":\"40\"},{\"enabledFlag\":1,\"meaning\":\"品牌孵化中心-碧恩丝\",\"orderSeq\":41,\"value\":\"41\"},{\"enabledFlag\":1,\"meaning\":\"品牌孵化中心-YABY\",\"orderSeq\":42,\"value\":\"42\"},{\"enabledFlag\":1,\"meaning\":\"品牌孵化中心-布朗杜\",\"orderSeq\":43,\"value\":\"43\"},{\"enabledFlag\":1,\"meaning\":\"品牌孵化中心-驴博士\",\"orderSeq\":44,\"value\":\"44\"},{\"enabledFlag\":1,\"meaning\":\"天猫保税\",\"orderSeq\":45,\"value\":\"45\"},{\"enabledFlag\":1,\"meaning\":\"行云联盟\",\"orderSeq\":46,\"value\":\"46\"},{\"enabledFlag\":1,\"meaning\":\"Linkiebuy\",\"orderSeq\":47,\"value\":\"47\"},{\"enabledFlag\":1,\"meaning\":\"品牌TP\",\"orderSeq\":48,\"value\":\"48\"},{\"enabledFlag\":1,\"meaning\":\"天马\",\"orderSeq\":49,\"value\":\"49\"},{\"enabledFlag\":1,\"meaning\":\"荔枝\",\"orderSeq\":50,\"value\":\"50\"},{\"enabledFlag\":1,\"meaning\":\"品牌孵化中心-小西记\",\"orderSeq\":51,\"value\":\"51\"},{\"enabledFlag\":1,\"meaning\":\"品牌孵化中心-迷珂宝\",\"orderSeq\":52,\"value\":\"52\"},{\"enabledFlag\":1,\"meaning\":\"品牌孵化中心-EQQUALBERRY\",\"orderSeq\":53,\"value\":\"53\"},{\"enabledFlag\":1,\"meaning\":\"品牌孵化中心-POPO-MASS\",\"orderSeq\":54,\"value\":\"54\"},{\"enabledFlag\":1,\"meaning\":\"品牌孵化中心-贴牌品牌\",\"orderSeq\":55,\"value\":\"55\"},{\"enabledFlag\":1,\"meaning\":\"社区团购-美团\",\"orderSeq\":56,\"value\":\"56\"},{\"enabledFlag\":1,\"meaning\":\"社区团购-多多买菜\",\"orderSeq\":57,\"value\":\"57\"},{\"enabledFlag\":1,\"meaning\":\"社区团购-橙心\",\"orderSeq\":58,\"value\":\"58\"},{\"enabledFlag\":1,\"meaning\":\"社区团购-兴盛\",\"orderSeq\":59,\"value\":\"59\"},{\"enabledFlag\":1,\"meaning\":\"非项目\",\"orderSeq\":60,\"value\":\"60\"},{\"enabledFlag\":1,\"meaning\":\"公文交换部门\",\"orderSeq\":61,\"value\":\"61\"}]");
        String json2StrStr=json2StrJsonArray.stream().map(item->{JSONObject jsonObj = JSONObject.parseObject(JSONObject.toJSONString(item));return jsonObj.getString("meaning") ;}).collect(Collectors.joining(","));
        System.out.println(json2StrStr);
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
    static class Test<T>{
        private String testStr1;
        private String testStr2;
        private Long testLong1;
        private Date date1;
        private LocalDate localDate1;
        private T test;
    }
}
