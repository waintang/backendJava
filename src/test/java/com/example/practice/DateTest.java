package com.example.practice;

import com.example.practice.utils.DateUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;
import java.util.Objects;

public class DateTest {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date22  = sdf.parse("2022-11-28"); // 抛错：java.text.ParseException：Unparseable date: "2022-11-28"


        new Date("99999/12/31");
        Date date1 = DateUtils.parseDate("20221103","yyyyMMdd");
        //返回当前系统默认的时区
        ZoneId zoneId = ZoneId.systemDefault();
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
        String dateStr = "2022-4-12 sfs"; // "2022-4-12 17:47:23";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = formatter.parse(dateStr);
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
