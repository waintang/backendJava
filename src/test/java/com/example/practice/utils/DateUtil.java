package com.example.practice.utils;

//import org.apache.commons.lang.StringUtils;
//import org.apache.commons.lang.Validate;
//import org.apache.commons.lang.math.NumberUtils;
//import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang3.*;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {
    public static final long MILLIS_PER_SECOND = 1000L;
    public static final long MILLIS_PER_MINUTE = 60000L;
    public static final long MILLIS_PER_HOUR = 3600000L;
    public static final long MILLIS_PER_DAY = 86400000L;
    public static final int[] MONTH_LENGTH = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static final String yyyyMMddSimple = "yyyyMMdd";
    public static final String yyyyMMdd = "yyyy-MM-dd";
    public static final String yyyyMM = "yyyy-MM";
    public static final String yyyyMMddSTANDARD = "yyyy年MM月dd日";
    public static final String yyyyMMddHH24 = "yyyy-MM-dd HH:mm:ss";
    public static final String yyyyMMddSlash = "yyyy/MM/dd";
    public static final String yyyyMMddHH24Slash = "yyyy/MM/dd HH:mm:ss";
    public static final String timestamp = "yyyyMMddHHmmss";
    public static final String CST = "EEE MMM dd HH:mm:ss zzz yyyy";
    private static final SimpleDateFormat formatYMD = new SimpleDateFormat("yyyy/MM/dd");
    private static final SimpleDateFormat formatYMD24 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static final SimpleDateFormat formatYMDSimple = new SimpleDateFormat("yyyyMMdd");
    private static final SimpleDateFormat formatYMDStd = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat formatYMD24Std = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat formatYMD24Slash = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static final SimpleDateFormat formatTimestamp = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final SimpleDateFormat formatYMDSlash = new SimpleDateFormat("yyyy/MM/dd");
    private static final SimpleDateFormat formatCST;
    private static Map<String, SimpleDateFormat> formats;

    public DateUtil() {
    }

    public static Date now() {
        return new Date();
    }

    public static Date str2Date(String dateStr) {
        Date date = null;
        if (!StringUtils.isEmpty(dateStr)) {
            if (dateStr.contains("年")) {
                dateStr = dateStr.replace("年", "-");
            }

            if (dateStr.contains("月")) {
                dateStr = dateStr.replace("月", "-");
            }

            if (dateStr.contains("日")) {
                dateStr = dateStr.replace("日", "");
            }

            SimpleDateFormat sdf = null;
            String pattern = "yyyy-MM-dd";
            if (dateStr.contains("CST")) {
                pattern = "EEE MMM dd HH:mm:ss zzz yyyy";
            } else if (dateStr.contains(":")) {
                if (dateStr.contains("-")) {
                    pattern = "yyyy-MM-dd HH:mm:ss";
                } else {
                    pattern = "yyyy/MM/dd HH:mm:ss";
                }
            } else if (dateStr.contains("/")) {
                pattern = "yyyy/MM/dd";
            } else if (dateStr.length() == 8) {
                if (dateStr.contains("-")) {
                    pattern = "yyyy-MM-dd";
                } else {
                    pattern = "yyyyMMdd";
                }
            }

            sdf = (SimpleDateFormat)formats.get(pattern);
            date = sdf.parse(dateStr, new ParsePosition(0));
        }

        return date;
    }

    public static Date str2Date(String dateStr, String pattern) {
        if (!StringUtils.isEmpty(dateStr)) {
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            return dateFormat.parse(dateStr, new ParsePosition(0));
        } else {
            return null;
        }
    }

    public static String date2timestamp(Date date) {
        String dateStr = null;
        if (date != null) {
            dateStr = formatTimestamp.format(date);
        }

        return dateStr;
    }

    public static String date2timestamp() {
        return date2timestamp(now());
    }

    public static String date2Str(Date date) {
        String dateStr = null;
        if (date != null) {
            dateStr = formatYMD.format(date);
        }

        return dateStr;
    }

    public static String date2StrYM(Date date) {
        String dateStr = null;
        if (date != null) {
            dateStr = date2Str(date, "yyyy-MM");
        }

        return dateStr;
    }

    public static String date2StrStandard(Date date) {
        String dateStr = null;
        if (date != null) {
            dateStr = date2Str(date, "yyyy年MM月dd日");
        }

        return dateStr;
    }

    public static String date2StrSimple(Date date) {
        String dateStr = null;
        if (date != null) {
            dateStr = date2Str(date, "yyyyMMdd");
        }

        return dateStr;
    }

    public static String date2Str24H(Date date) {
        String dateStr = null;
        if (date != null) {
            dateStr = formatYMD24.format(date);
        }

        return dateStr;
    }

    public static String date2Str(Date date, String pattern) {
        String dateStr = null;
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            dateStr = sdf.format(date);
        }

        return dateStr;
    }

    public static Date dayBegin(Date date) {
        date = DateUtils.setMilliseconds(date, 0);
        date = DateUtils.setHours(date, 0);
        date = DateUtils.setMinutes(date, 0);
        date = DateUtils.setSeconds(date, 0);
        return date;
    }

    public static Date dayEnd(Date date) {
        date = DateUtils.setHours(date, 23);
        date = DateUtils.setMinutes(date, 59);
        date = DateUtils.setSeconds(date, 59);
        return date;
    }

    public static int daysBetween(Date startDate, Date endDate) {
        Validate.notNull(startDate);
        Validate.notNull(endDate);
        startDate = dayBegin(startDate);
        endDate = dayBegin(endDate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(endDate);
        long time2 = cal.getTimeInMillis();
        long days = (time2 - time1) / 86400000L;
        return NumberUtils.toInt(String.valueOf(days));
    }

    public static int monthsBetween(Date startDate, Date endDate) {
        Validate.notNull(startDate);
        Validate.notNull(endDate);
        Calendar calendarFrom = Calendar.getInstance();
        calendarFrom.setTime(startDate);
        Calendar calendarTo = Calendar.getInstance();
        calendarTo.setTime(endDate);
        return (calendarTo.get(1) - calendarFrom.get(1)) * 12 + calendarTo.get(2) - calendarFrom.get(2);
    }

    public static boolean isBetween(final Date date, final Date start, final Date end) {
        if (date != null && start != null && end != null && !start.after(end)) {
            return !date.before(start) && !date.after(end);
        } else {
            throw new IllegalArgumentException("some time parameters is null or dateBein after dateEnd");
        }
    }

    public static boolean isLeapYear(final Date date) {
        return isLeapYear(get(date, 1));
    }

    public static boolean isLeapYear(int y) {
        boolean result = false;
        if (y % 4 == 0 && (y < 1582 || y % 100 != 0 || y % 400 == 0)) {
            result = true;
        }

        return result;
    }

    public static boolean isSameDay(final Date date1, final Date date2) {
        return DateUtils.isSameDay(date1, date2);
    }

    public static boolean isSameTime(final Date date1, final Date date2) {
        return date1.compareTo(date2) == 0;
    }

    public static int getMonthLength(int year, int month) {
        if (month >= 1 && month <= 12) {
            if (month == 2) {
                return isLeapYear(year) ? 29 : 28;
            } else {
                return MONTH_LENGTH[month];
            }
        } else {
            throw new IllegalArgumentException("Invalid month: " + month);
        }
    }

    public static int getMonthLength(final Date date) {
        int year = get(date, 1);
        int month = get(date, 2);
        return getMonthLength(year, month + 1);
    }

    public static Date getFirstDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        return calendar.getTime();
    }

    public static Date getLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(5, getMonthLength(date));
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        return calendar.getTime();
    }

    public static int getYear(Date date) {
        return get(date, 1);
    }

    public static int getYear(String dateStr) {
        return getYear(str2Date(dateStr));
    }

    public static int getMonth(Date date) {
        return get(date, 2) + 1;
    }

    public static int getMonth(String dateStr) {
        return getMonth(str2Date(dateStr));
    }

    public static int getDay(Date date) {
        return get(date, 5);
    }

    public static int getDay(String dateStr) {
        return getDay(str2Date(dateStr));
    }

    private static int get(final Date date, int field) {
        Validate.notNull(date, "time", new Object[0]);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(field);
    }

    public static Date addMonths(final Date date, int amount) {
        return DateUtils.addMonths(date, amount);
    }

    public static Date subMonths(final Date date, int amount) {
        return DateUtils.addMonths(date, -amount);
    }

    public static Date addWeeks(final Date date, int amount) {
        return DateUtils.addWeeks(date, amount);
    }

    public static Date subWeeks(final Date date, int amount) {
        return DateUtils.addWeeks(date, -amount);
    }

    public static Date addDays(final Date date, final int amount) {
        return DateUtils.addDays(date, amount);
    }

    public static Date subDays(final Date date, int amount) {
        return DateUtils.addDays(date, -amount);
    }

    public static Date addHours(final Date date, int amount) {
        return DateUtils.addHours(date, amount);
    }

    public static Date subHours(final Date date, int amount) {
        return DateUtils.addHours(date, -amount);
    }

    public static Date addMinutes(final Date date, int amount) {
        return DateUtils.addMinutes(date, amount);
    }

    public static Date subMinutes(final Date date, int amount) {
        return DateUtils.addMinutes(date, -amount);
    }

    public static Date addSeconds(final Date date, int amount) {
        return DateUtils.addSeconds(date, amount);
    }

    public static Date subSeconds(final Date date, int amount) {
        return DateUtils.addSeconds(date, -amount);
    }

    public static String formatFriendlyTime(long timeStampMillis) {
        long now = System.currentTimeMillis();
        long span = now - timeStampMillis;
        if (span < 0L) {
            return String.format("%tc", timeStampMillis);
        } else if (span < 1000L) {
            return "刚刚";
        } else if (span < 60000L) {
            return String.format("%d秒前", span / 1000L);
        } else if (span < 3600000L) {
            return String.format("%d分钟前", span / 60000L);
        } else {
            long wee = DateUtils.truncate(new Date(now), 5).getTime();
            if (timeStampMillis >= wee) {
                return String.format("今天%tR", timeStampMillis);
            } else {
                return timeStampMillis >= wee - 86400000L ? String.format("昨天%tR", timeStampMillis) : String.format("%tF", timeStampMillis);
            }
        }
    }

    public static String formatFriendlyTime(Date date) {
        Validate.notNull(date);
        return formatFriendlyTime(date.getTime());
    }

    public static int getNowHours() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(11);
    }

    public static int getNowMinutes() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(12);
    }

    public static int getNowSeconds() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(13);
    }

    public static Date addTime(Date date) {
        if (date == null) {
            return null;
        } else {
            Calendar calendar = Calendar.getInstance();
            date.setHours(calendar.get(11));
            date.setMinutes(calendar.get(12));
            date.setSeconds(calendar.get(13));
            return date;
        }
    }

    private static int getCompareResult(Date date1, Date date2) {
        Validate.notNull(date1);
        Validate.notNull(date2);
        return date1.compareTo(date2);
    }

    public static boolean greaterThan(Date date1, Date date2) {
        return getCompareResult(date1, date2) > 0;
    }

    public static boolean greaterEqualThan(Date date1, Date date2) {
        int result = getCompareResult(date1, date2);
        return result > 0 || result == 0;
    }

    public static boolean equal(Date date1, Date date2) {
        return getCompareResult(date1, date2) == 0;
    }

    public static boolean lessThan(Date date1, Date date2) {
        return getCompareResult(date1, date2) < 0;
    }

    public static boolean lessEqualThan(Date date1, Date date2) {
        int result = getCompareResult(date1, date2);
        return result < 0 || result == 0;
    }

    static {
        formatCST = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        formats = new HashMap();
        formats.put("yyyyMMdd", formatYMDSimple);
        formats.put("yyyy-MM-dd", formatYMDStd);
        formats.put("yyyy-MM-dd HH:mm:ss", formatYMD24Std);
        formats.put("yyyy/MM/dd HH:mm:ss", formatYMD24Slash);
        formats.put("yyyy/MM/dd", formatYMDSlash);
        formats.put("EEE MMM dd HH:mm:ss zzz yyyy", formatCST);
    }
}
