package com.example.practice;

import cn.hutool.core.util.ArrayUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayTest {
    public static void main(String[] args) {
        String[] scalaArr =new String[]{};
        testContain();

        scalaArr[0]="C";
        scalaArr[2]="C";
        String[] IGNORE_FIELD_NAMES =new String[]{"A","B"};
        String[] ignoreFieldNames =new String[]{"A","D"};
        testArr(IGNORE_FIELD_NAMES);

        // List转数组
        List<String> canShowDocDiffTypeList = new ArrayList<>();
//        canShowDocDiffTypeList.add("DELETE");
//        canShowDocDiffTypeList.add("UPDATE");
        String[] canShowDocDiffTypes = canShowDocDiffTypeList.toArray(new String[]{});
        System.out.println(canShowDocDiffTypes);
    }

    private static void testArr(String[] IGNORE_FIELD_NAMES,String... ignoreFieldNames){
        System.out.println(JSONObject.toJSONString(IGNORE_FIELD_NAMES));
        String[] allArr1 = ArrayUtil.append(IGNORE_FIELD_NAMES,ignoreFieldNames);
        String[] allArr2 = ArrayUtil.addAll(IGNORE_FIELD_NAMES,ignoreFieldNames);
        String[] allDistinctArr = ArrayUtil.distinct(allArr2);
        allArr1 = ArrayUtil.sub(allArr1,0,1);
        List<String> ignoreFieldNameList = Arrays.asList(allArr1);
        System.out.println(ignoreFieldNameList);

    }

    private static void testContain(String... arr){
        Boolean containFlag = ArrayUtils.contains(arr,"a");
        System.out.println(containFlag);
    }
}
