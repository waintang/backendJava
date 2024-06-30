package com.example.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {
    public static void main(String args[]) {
        String url240317 = "public/483/HUAWEI_CLOUD/87e29afd5a5241a6b648eec49a9bbf93@TWP2024031701外协-附件压缩埋点&附件回调保存&任意人直接完成外协&查询对方新增的协同人-外协附件-2024/03/17 19:23:42.zip";
        String[] fileUrlAttr = url240317.split("(://|/|%40|@)");

        String str = "1345678234";
        String pattern = "^(13[0-9]|14[5|7]|15[0|1|2|3|4|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        System.out.println(m.matches());
        // 文件名 特殊字符
        String fileName = "ab*a";
        pattern = "[\\\\/:*?\"<>|+ %#&=@_$]+";
        r = Pattern.compile(pattern);
        m = r.matcher(fileName);
        if (m.find()) {
            System.out.println("正文文件名包含\\/:*?\"<>|+空格%#&=@_$等特殊字符");
        }
    }
}
