package com.example.practice.collection;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapTest {
    public static void main(String[] args) {
        Map<String,SignFileVO> emptyMap = new HashMap<>();
//        emptyMap.stream().collect(Collectors.toMap(SignFileVO::getDocumentUuid, Function.identity()));
        SignFileVO signFileVO = emptyMap.get("uuu");
        System.out.println("状态："+emptyMap.containsKey("sfsf"));
        System.out.println("signFileVO:{}"+ JSONObject.toJSONString(signFileVO));
        // ############ 空value 对比
        Map<String ,Long > emptyLongMap = new HashMap<>();
        Long valueLong = emptyLongMap.get("twp");
        System.out.println(valueLong>2);
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    private static class SignFileVO{
        private String documentUuid;
    }
}
