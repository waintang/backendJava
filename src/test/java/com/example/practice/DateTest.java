package com.example.practice;

import com.example.practice.utils.DateUtil;
import org.joda.time.DateTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) throws ParseException {

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
}
