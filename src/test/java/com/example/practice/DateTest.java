package com.example.practice;

import com.alibaba.fastjson.util.TypeUtils;
import com.example.practice.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class DateTest {
    public static boolean isLastDay(){
        DateTime now = DateTime.now();
        DateTime lastDateTime = now.dayOfMonth().withMaximumValue();
        int maxDayOfMonth = lastDateTime.getDayOfMonth();
        return  maxDayOfMonth == now.getDayOfMonth();
    }
    public static void main(String[] args) throws ParseException {
        Date now121501 = new Date();
        Long millis = System.currentTimeMillis();
        System.out.println("当前毫秒数："+millis);
        System.out.println("===isLastDay:"+isLastDay());

        Date date230610 = TypeUtils.castToDate("2023-04-29T09:00:00+08:00");

        Date date230606 = new Date(1701259985451L);
        System.out.println(DateUtil.date2Str24H(date230606));

        String dateStr060601 = String.valueOf(DateUtil.getDateTime("2024-01-08","yyyy-MM-dd").getMillis());
        String dateStr060602 = String.valueOf(DateUtil.getDateTime("2023-06-04","yyyy-MM-dd").getMillis());
        System.out.println(dateStr060601);
        System.out.println(dateStr060602);

        // Date 和 LocalDate 格式区别
        String dateStr = "2022/12/10";
        Date nowDate = new Date(dateStr);
        // Joda-Time
        DateTime dateTime = DateTime.parse(dateStr, DateTimeFormat.forPattern("yyyy/MM/dd"));
        System.out.println("nowDate:"+String.valueOf(nowDate));
        Instant instant = nowDate.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        // atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
        LocalDate nowLocalDate = instant.atZone(zoneId).toLocalDate();
        System.out.println("nowLocalDate:"+String.valueOf(nowLocalDate));
//        String betweenDateStr = cn.hutool.core.date.DateUtil.formatBetween(1651680000000L);
//        cn.hutool.core.date.DateTime betweenDate = cn.hutool.core.date.DateUtil.date(1651680000000L);
//        cn.hutool.core.date.DateTime dateTime = cn.hutool.core.date.DateUtil.parseDate(betweenDateStr);
        SimpleDateFormat formatCST = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);

        Date cstDate = formatCST.parse("Thu May 05 00:00:00 CST 2022", new ParsePosition(0));
//        Date cstDate = formatCST.parse("Sun Mar 06 00:00:00 CST 2022", new ParsePosition(0));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        Date date22  = sdf.parse("2022-11-28"); // 抛错：java.text.ParseException：Unparseable date: "2022-11-28"

        String valueDateStr = "2021/2/3";
        Date valueDate = new Date(valueDateStr);
        Date toolDate = DateUtil.str2Date(valueDate.toString());


        new Date("99999/12/31");
        Date date1 = DateUtils.parseDate("20221103","yyyyMMdd");
        //返回当前系统默认的时区
        zoneId = ZoneId.systemDefault();
        //atZone()方法返回在指定时区,从该Instant生成的ZonedDateTime
        ZonedDateTime zonedDateTime = date1.toInstant().atZone(zoneId);
        LocalDate localDate =  zonedDateTime.toLocalDate();

        Boolean bool = localDate.isBefore(LocalDate.now());
        DateTime now = DateTime.now();
        DateTime before5Day = now.minusDays(4);
        before5Day.getDayOfYear();
        before5Day.getDayOfMonth();
        before5Day.getYear();
        Date before5Date = before5Day.toDate();
        Date beforeDate = DateUtil.str2Date(before5Day.getYear()+"-"+before5Day.getMonthOfYear()+"-"+before5Day.getDayOfMonth(), DateUtil.yyyyMMdd);
        System.out.println(before5Day);

        LocalDateTime lastUpdatedTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong("1657854001000")), ZoneId.systemDefault());

        System.out.println(lastUpdatedTime);

        DateFormat dateFormat = DateFormat.getDateInstance();
        Date dateDirect = dateFormat.parse("2022/4/12");
        System.out.println("dateDirect:"+dateDirect);
        String dateStr2 = "2022-4-12 sfs"; // "2022-4-12 17:47:23";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = formatter.parse(dateStr2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static String getFinalMessage(Throwable e){
        if(Objects.isNull(e.getCause()) ) {
            return e.getMessage();
        }
        return getFinalMessage(e.getCause());
    }
}
