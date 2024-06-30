package com.example.practice;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.ParserContext;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
//        Boolean bool240605 = org.apache.commons.lang3.StringUtils.isAnyBlank("adf",String.valueOf(null));

        String toEmails230911 = "123@qq.com,ddfsf@em.com";
        String[] toEmailArr = toEmails230911.split("[,;]");

        String str230629 = "sdfasdfasdf@手动阀手动阀";
        String[] strArr230629 = str230629.split("@");

        String str230626 = "甄零内部研发项目-技术中心-OF/OL/I16-2023年@ZLNB202300005-03";
        String result230625 = str230626.substring(0,str230626.lastIndexOf("@"));

        String contractName = "TWP";
        String contractNumber = "";
        String str230509 = contractName + "[" + (StringUtils.hasLength(contractNumber) ? contractNumber : " ") + "]";

        String str230407 = StrUtil.padPre(12+"",3,'0');
        String addStr230329 = "abc"+null;

        List<Long> tenantIdList = Arrays.stream("".split(",")).filter(item->StringUtils.hasLength(item)).map(item->Long.valueOf(item)).collect(Collectors.toList());

        StringBuilder strSb20230327 = new StringBuilder();
        strSb20230327.append("abc");
        strSb20230327.append(new StringBuilder());

        String abc2 = "lastStatusCode = \"N\",";
        String pattern = "[a-z]+";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(abc2);
        System.out.println(m.matches());

        String tempBatchCode = "FS-2023021701@1";
        int separatorIndex = tempBatchCode.lastIndexOf("@");
        String batchCode = tempBatchCode.substring(0,separatorIndex);
        String batchCode2 = tempBatchCode.substring(0,2);
        String trueBatchCode = tempBatchCode.substring(separatorIndex+1);

        String postfixStr = "abc.sdfs.docx"; // postfixStr.lastIndexOf(".")>0?postfixStr.substring(0,postfixStr.lastIndexOf(".")):postfixStr
        String subPostfixStr = postfixStr.substring(0,postfixStr.lastIndexOf("."));
        StringBuilder sb2 = new StringBuilder();
        String emptyString = sb2.toString();
        String testReg = "甄零(上海）公司";
//        String testReg2 = testReg.replaceAll("(上海）","");
        StringBuilder errMsgSb = new StringBuilder();
        String errMsgStr = errMsgSb.toString();
        String key = "base:batch-import:481:1675156768061";
        String tenantId = key.substring(key.indexOf(":", 5) + 1, key.lastIndexOf(":"));
        String a = "io.chor.main.CommonExcp:手动阀手动阀at dfa.sdf.(dfs...";
        String b = a.replaceFirst("([a-zA-Z]+\\.)+[a-zA-Z]+:","");
        Map map = JSONObject.parseObject("{\"id\":242125,\"sourceContractId\":218983,\"rootContractUuid\":\"6cbaa45881ed478a8c67efb6027913b0\",\"createSourceType\":\"CHANGE\",\"latest\":false,\"contractNumber\":\"-2022112900043\",\"contractSerialNumber\":\"HT2022112900047\",\"contractName\":\"B22112740A11哈啰-九福线缆销售合同 1\",\"companyId\":1,\"companyName\":\"上海哈啰普惠科技有限公司\",\"categoryName\":\"软件研发中心/我要付款\",\"inOutTypeCode\":\"E\",\"propertyCode\":\"ORDINARY\",\"departmentName\":\"哈啰/软件研发中心/基础技术/基础设施运维/IDC网络\",\"departmentId\":25833,\"belongingDepartmentName\":\"哈啰/软件研发中心/基础技术/基础设施运维/IDC网络\",\"belongingDepartmentId\":25833,\"startDate\":\"2022-11-29\",\"endDate\":\"2023-10-29\",\"amount\":7350.00,\"currency\":\"CNY\",\"principalName\":\"刘启\",\"principalId\":23319,\"statusCode\":\"A\",\"executeStatusCode\":\"N\",\"lastStatusCode\":\"P\",\"creationMethodCode\":\"MANUAL\",\"creator\":\"刘启\",\"creationDate\":1672826480000,\"version\":0,\"tenantId\":16,\"objectVersionNumber\":16,\"createdBy\":256793532323536896,\"categoryUuid\":\"00231e3bcac14b5d976cc24a31f4fdf4\",\"contentUuid\":\"d3e1c02022e042208fef537e262ea086\",\"applyRuleId\":250370666187067392,\"createSettleFlag\":0,\"unitCompanyId\":9579,\"categoryCode\":\"10011703\",\"lastVersionAmount\":0.00,\"totalChangeAmount\":0.00,\"approvedDate\":\"2022-12-16T15:41:24\",\"closed\":\"NO\",\"renewed\":\"NO\",\"closedBy\":0,\"textSource\":\"LOCAL\",\"submitTime\":1669710938000,\"watermarkFlag\":1,\"isCooperative\":false,\"approvalTime\":1465545899,\"approvalNumber\":1,\"workflowBusinessKey\":\"HCBM_CONTRACT:6cbaa45881ed478a8c67efb6027913b0\",\"createFrom\":\"OLD\",\"changeApprovalFlag\":false,\"invertedFlag\":\"NO\",\"sourceCreationDate\":1669710291000,\"tradingName\":\"九福科技信息技术有限公司\",\"capitalAmount\":\"柒仟叁佰伍拾元整\",\"existChange\":\"false\",\"existSync\":false,\"attributeVarchar13\":\"false\",\"attributeLongtext1\":\"机房二期建设所需耗材，单模光纤跳线，由于低于2W元采购标准，根据公司规范自行提交。在全年预算内。\",\"uuid\":\"622616934c314458bf2c4ee5b93652ce\",\"lastUpdateDate\":1673229103000,\"lastUpdatedBy\":246931501726470144,\"_token\":\"1UtcMtQqTmSqd+Hcz0TAHfA2dtwdGDbdY1ASC28hWw4+blOsCw9AzX/5SVACz82cTYvKXJw7MBVV5syqg6LMAQ==\",\"flex\":{}}",Map.class);

        String str1 = "ExceptionUtil.stacktraceToOneLineString(e) ";
        str1.replace("Exception","Excetption").replace("stack","stac2k");
        str1.trim();
        String abc = StrUtil.maxLength(str1,150) ;
//        String abc = StrUtil.sub(str1,0,10) ;
        System.out.println(str1.length());
        System.out.println(abc);
        boolean bool1 = "王明亮".contains("王明");
        System.out.println(bool1);
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.toString());
        String ss = "asdfasdfdf/12z(修订过）.doc";
        String fileName1 = "12z(修订过）.doc";
//下面就会报错
        System.out.println(ss.replaceAll("12z（修订过）.doc", ""));

        String fileName = "20221025 as副本测试变更20221025 - 副本测试变更20221025 20221025 as副本测试变更20221025 - 副本测试变更2022102520221025 as副本测试变更20221025 - 副本测试变更2022102520221025 as副";
        System.out.println(fileName.length());
        String[] fileNames = fileName.split("[，2]");
        System.out.println(fileName.length());
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
