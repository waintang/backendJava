package com.example.practice;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.util.Strings;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        String mapStream = "[{\"contentId\":1,\"textSource\":\"null\"},{\"contentId\":2,\"textSource\":\"本地文本\"},{\"contentId\":3,\"textSource\":\"abc\"}]";
        JSONArray array = JSONArray.parseArray(mapStream);
        List<Long> arrayLongs = array.stream().filter(item-> Strings.isEmpty(((JSONObject) item).getString("textSource"))).map(item->((JSONObject) item).getLong("contentId")).collect(Collectors.toList());
        System.out.println(JSONObject.toJSONString(arrayLongs));
        System.out.println(!CollectionUtils.isEmpty(arrayLongs));
        Boolean bool = array.stream().anyMatch(item-> Strings.isEmpty(((JSONObject) item).getString("textSource")));
        System.out.println(bool);
        int[] intArr = new int[]{3,1,2,0,20};
        OptionalInt first = Arrays.stream(intArr).max();
        List<Integer> integerList = new ArrayList<>();
        integerList.add(3);
        integerList.add(1);
        integerList.add(2);
        integerList.add(20);
        integerList.add(0);
        Optional<Integer> first1 = integerList.stream().sorted(Comparator.reverseOrder()).findFirst();
        System.out.println(first1.get());
        System.out.println(InnerClass.class);

        String[] abc = {"12","23","1111234","34","35"};
        String str = Arrays.stream(abc).filter(item->"twp".equals(item.equals(item))).findAny().get();
        Optional<String> optional = Arrays.stream(abc).filter(item->"twp".equals(item.equals(item))).findAny();
        Arrays.stream(abc).peek(item-> System.out.println(Short.valueOf(item))).collect(Collectors.toList());
//        for(String abcd : abc){
//            System.out.println(abcd);
//        }
    }

    public class InnerClass{
        private int a;
        public int test(){
            return 1;
        }
    }
}
