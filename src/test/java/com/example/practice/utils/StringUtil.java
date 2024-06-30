package com.example.practice.utils;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class StringUtil {

    public static void main(String[] args) {
        try {
            Object obj1 = StringUtil.convertValue(Boolean.class,"true");
            Object obj2 = StringUtil.convertValue(Long.class,"23");
            Object obj3 = StringUtil.convertValue(Integer.class,"24");
            Object obj4 = StringUtil.convertValue(LocalDate.class,"2023/01/11");
            Object obj5 = StringUtil.convertValue(Date.class,"2023/01/13");
            Object obj6 = StringUtil.convertValue(BigDecimal.class,"123.34");
            Object obj7 = StringUtil.convertValue(String.class,"abc12唐");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static Object convertValue(Class<?> type, String value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        if (Long.class.equals(type) || Integer.class.equals(type) || Boolean.class.equals(type)){
            Method valueOf = type.getDeclaredMethod("valueOf", String.class);
            valueOf.setAccessible(true);
            if(StringUtils.isBlank(value)){
                return null;
            }
            return valueOf.invoke(null, value);
        }
        if (Date.class.equals(type)){
            return DateUtil.str2Date(value);
        }
        if (LocalDate.class.equals(type)){
            if(StringUtils.isBlank(value)){
                return null;
            }

            Date date = DateUtil.str2Date(value);
            Instant instant = date.toInstant();
            ZoneId zoneId = ZoneId.systemDefault();
            // atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
            LocalDate nowLocalDate = instant.atZone(zoneId).toLocalDate();
            return nowLocalDate;

//            Method valueOf = type.getDeclaredMethod("parse", CharSequence.class);
//            valueOf.setAccessible(true);
//            return valueOf.invoke(null, value);
        }
        if (BigDecimal.class.equals(type)){
            Constructor constructor = type.getConstructor(String.class);
            constructor.setAccessible(true);
            return constructor.newInstance(value);
        }
        if (String.class.equals(type)){
            return value;
        }
        return null;
    }

}
