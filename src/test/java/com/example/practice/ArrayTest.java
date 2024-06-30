package com.example.practice;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ArrayTest {
    public static void main(String[] args) {
        Boolean test042801 = null;
        Boolean test042802 = test042801 && true;
        int[] intArr231022 =new int[]{};
//        System.out.println(intArr231022*2); // java报错，而python不报错
        boolean bool231022 = true;
        Boolean bool23102202 = true;
        System.out.println(ObjectUtil.isBasicType(bool231022));
        System.out.println(bool23102202.getClass().isPrimitive());
//        System.out.println(bool23102202 instanceof boolean);// 报错
        System.out.println(bool23102202 instanceof Boolean);
        System.out.println(Father.class.isAssignableFrom(Son.class)); // Son对象是否可赋值给Father对象?
        Father father = new Father();
        Son son = new Son();
        father = son;
//        son = father; // 报错
        if(true){
            System.out.println("True");
        }else if(false){

        }
        String[] scalaArr =new String[]{};
        System.out.println(scalaArr);
        List<String> tempList = new ArrayList<>();
        tempList.add("a");
        tempList.add("b");
        scalaArr = tempList.toArray(new String[]{});
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

    private static class Father {

    }

    private static class  Son extends Father{

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
