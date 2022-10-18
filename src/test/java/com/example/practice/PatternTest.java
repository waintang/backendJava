package com.example.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {
    public static void main(String args[]) {
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
