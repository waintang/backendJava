package com.example.practice;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Collectors;

public class StringTest {
    private static String lowerFirst(String str){
        char[] cs = str.toCharArray();
        cs[0]+=32;
        return String.valueOf(cs);
    }
    private static String upperFirst(String str){
        char[] cs = str.toCharArray();
        cs[0]-=32;
        return String.valueOf(cs);
    }


    public static String removeTypeSuffix(String fileName) {
        if (StringUtils.isEmpty(fileName)) {
            return fileName;
        } else {
            int pointIndex = fileName.lastIndexOf(".");
            if (pointIndex == -1) {
                return fileName;
            } else {
                String suffix = fileName.substring(pointIndex);
                int suffixIndex = fileName.indexOf(suffix);
                return suffixIndex == -1 ? fileName.substring(0, pointIndex) : fileName.substring(0, suffixIndex);
            }
        }
    }

    public static void main(String[] args) {
        Set<String> codeSet = new HashSet<>();
        codeSet.add("a");
        codeSet.add("b");
        Object[] codeArr = codeSet.toArray();
        String codeArrStr = org.apache.commons.lang3.StringUtils.join(codeArr,",");
//        StringUtils.
        System.out.println(codeArrStr);
        String codeSetStr = codeSet.stream().map(item->"\""+item+"\"").collect(Collectors.joining(",","[","]"));
        System.out.println(codeSetStr);

        String[] explicitListValues = new String[]{"123","唐文2"};
        long arrLen = explicitListValues.length;
        long strLength = Arrays.stream(explicitListValues).map(item->StringUtils.hasLength(item)?item.length():0).reduce(0,(acc,x)->acc+x);

        if(arrLen + strLength > 7){
            System.out.println(">7");
        }

        String fileName2 = "德高品牌-1-2022年度德高零售区域总经销协议 V5清洁版.doc";
        String suffix = fileName2.substring(fileName2.lastIndexOf(".") + 1);
        System.out.println(suffix);
    }
    public static void main2(String[] args) {

        String fileName2 = "德高品牌-1-2022年度德高零售区域总经销协议 V5清洁版.doc";
        String suffix = fileName2.substring(fileName2.lastIndexOf(".") + 1);
        System.out.println(suffix);

        Date originDate = new Date();
        System.out.println(String.valueOf(originDate));

        String test = "UserName";
        test.length();
        String[] en = new String[]{};
        int aen = en.length;
        System.out.println(lowerFirst(test));
        StringBuilder errMsgBuilder = new StringBuilder();
        String errMsg = null;
        errMsgBuilder.append(errMsg);
        System.out.println(errMsgBuilder.toString());
        String errMessage = "A唐文翩，柏明Z";
        System.out.println(errMessage.length());
        System.out.println(errMessage.length()>7?errMessage.substring(0,7):errMessage);

        System.out.println(String.valueOf(System.currentTimeMillis()));

        String sourceCode = "121324.fsd.890";
        boolean containFlag = sourceCode.contains(".");
        String after = removeTypeSuffix(sourceCode);
        String batchNumber = sourceCode.substring(0,sourceCode.lastIndexOf("."));
        String ccrtNum = sourceCode.substring(sourceCode.indexOf(".")+1,sourceCode.length());
        System.out.println(batchNumber);
        System.out.println(ccrtNum);

        String fileKey = "hcbm-contract/source-contract-file/534/ALIYUN_CLOUD/c383372b8ae64b429b80eb307b205681@ECARX-ZHHT-20211212-0010.pdf";
        System.out.println(fileKey.substring(fileKey.lastIndexOf("@")+1,fileKey.length()));
        // 文件名 去后缀
        String fileName = "我是excel.xlsx";
        Boolean containPrefix = fileName.contains(".");
        System.out.println("是否含后缀："+containPrefix);
        String exactFileName = fileName.substring(0,fileName.lastIndexOf("，"));
        System.out.println("文件名："+exactFileName);
        String addStr = "sdfsd,唐文翩";
        System.out.println(addStr.length());
        System.out.println(addStr.substring(0,9));
        String blankStr = "";
        String[] blankStrArr = blankStr.split(",");
        for(String relBatchIdStr : blankStrArr){
            Long.valueOf(relBatchIdStr);
            System.out.println(relBatchIdStr);
        }

//        ArrayBlockingQueue
// LongAdder
        boolean aBool = Strings.isEmpty(" ");

        boolean bBool = org.apache.commons.lang3.StringUtils.isEmpty(" ");

        Boolean testBoolean = null;
        if(Boolean.TRUE.equals(testBoolean)){
            System.out.println("true");
        }

        List<String> testPrint = new ArrayList<>();
        testPrint.add("Twp;");
        testPrint.add("Wen");
        System.out.println(testPrint.toString());

        String[] arr = new String[]{};
        System.out.println(arr.length);
        for(String bbb : arr){
            System.out.println(bbb);
        }

        Boolean isEditable = null;
        String resultErr = "";
        resultErr += (isEditable?"没有":"有")+"编辑权限;";
        System.out.println(resultErr);

        String error = "a";
        error+=";";
        System.out.println(error);
        error="@"+error;
        System.out.println(error);

        String strSub = "wod-我的-自定义合同行12";
        int middleHorizonLineNum = strSub.lastIndexOf("-");
        System.out.println(middleHorizonLineNum);
        System.out.println(strSub.length());
        System.out.println(strSub.substring(0,middleHorizonLineNum));
        System.out.println(strSub.substring(middleHorizonLineNum,strSub.length()));
        System.out.println(strSub.substring(middleHorizonLineNum,strSub.length()).startsWith("-自定义合同行"));

        String[] aArr = ArrayUtils.EMPTY_STRING_ARRAY;
        for(String aaa :aArr){
            System.out.printf(aaa);
        }

        String testSplit = "123";
        String[] testSplitArr = testSplit.split(",");

        System.out.println("***************************斜杠拆分");
        String xiegangStr = "G0 01 / G11 /";
        String[] a = StringUtils.delimitedListToStringArray(xiegangStr.endsWith("/")?xiegangStr.substring(0,xiegangStr.length()-1):xiegangStr,"/");
        System.out.println(a);
        for(String b :a){
            System.out.println(b.trim());
        }

        System.out.println("***************************测试String7前后intern差异");
        String h1=new String("22")+new String("1");//堆 22、1、221，堆-常量池：（jdk6时,22、1两字符串；jdk7时,堆22、1串的引用）
        h1.intern();// 堆221添加给 常量池：（jdk6时，221字符串给常量池；jdk7时，堆221串的引用给常量池）
        String h2="221"; // 此时，常量池有221，于是：h2（jdk6指向常量池221字符串的引用，jdk7借由常量池指向堆221字符串的引用 ）

        System.out.println("h1和h2 引用地址是否相同："+(h1 == h2));//result：jdk6 false；jdk7 true
        System.out.println("h1和h2 值是否相同："+h1.equals(h2));//result：true
        System.out.println("***************************");


        String testStr = "123唐文翩";
        System.out.println("length():"+testStr.length()+"substring:"+testStr.substring(0,5));
        System.out.println("***************************替换/仅保留特定字符");
        String aa = "223 3 #d 的 是个很__  EEE=+";
        aa = aa.replaceAll("[^a-zA-Z0-9\\u4E00-\\u9FA5]", "");  //去除数字，英文，汉字  之外的内容
        System.out.println(aa);  //输出为   2233d的是个很EEE
        aa = "74asdf";
        aa = aa.toLowerCase().replaceAll("[^a-z0-9]", "");  //转小写、去除数字，小写英文之外的内容
        System.out.println(aa);  //输出为   2233d的是个很EEE
//　　    replaceAll("[\\s*|\t|\r|\n]", "");  // 去除所有空格，制表符

    }
}
