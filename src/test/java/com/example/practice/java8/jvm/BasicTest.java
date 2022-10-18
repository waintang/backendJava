package com.example.practice.java8.jvm;

import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * 基础数据类型 测试
 */
public class BasicTest {
    private static int a=222;
    private static Integer b = Integer.valueOf(22);// new Integer(22);
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println("######### int 基础类型 是值传递");
        System.out.println(a);
        modifyTest(a);
        System.out.println(a);
        Integer.valueOf(2);
        System.out.println(244==a);
        System.out.println("######### Ineteger 包装类 是引用传递");
        System.out.println(b);
        modifyIntegerTest(b);
        System.out.println(b);
        System.out.println(Integer.valueOf(22)==b);

        System.out.println("######### jvm中 占的字节数、位数");
        Charset charset = Charset.defaultCharset();
        System.out.println(charset.toString());
        char achar = '\uAA85';
        System.out.println(achar);
        System.out.println((int)achar);
        System.out.println(Character.SIZE);

        String tang = "\uAA85";//""\uD834\uDF4E";
        System.out.println(tang);
        System.out.println(tang.length());
        System.out.println(tang.getBytes().length);
        System.out.println("a".getBytes().length);

        System.out.println("######### 特殊引用类型-类-String 值传递？");
        String aStr = "abc";
        aStr.intern();
        System.out.println(aStr);
        modifyStringTest(aStr);
        System.out.println(aStr);

        String newStr = new String("123");
        System.out.println(newStr);
        modifyNewStringTest(newStr);
        System.out.println(newStr);

        String str1 = new StringBuilder().append("Hello").append("World").toString();
        str1.intern();
        String str2 = "HelloWorld";
//        System.out.println("HelloWorld");
        System.out.println(str1 == str2);

        String s2 = new StringBuilder().append("Ja").append("va").toString();
        s2.intern();
        String s3 ="Java";
//        System.out.println("Java");
        System.out.println(s3== s2);

    }
    public static void modifyTest(int a){
        System.out.println(System.identityHashCode(a));
        a = 244;
        System.out.println(System.identityHashCode(a));
    }
    public static void modifyIntegerTest(Integer b){
        System.out.println(System.identityHashCode(b));
        b = new Integer(23);
        System.out.println(System.identityHashCode(b));
    }
    public static void modifyStringTest(String astr){
        astr = "def";
    }
    public static void modifyNewStringTest(String newstr){
        newstr = new String("456");
    }
}
