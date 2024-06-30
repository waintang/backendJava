package com.example.practice.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {

    public static final long MILLIS_PER_SECOND = 1000; // Number of milliseconds in a standard second.

    public static final long MILLIS_PER_MINUTE = 60 * MILLIS_PER_SECOND;

    public static final long MILLIS_PER_HOUR = 60 * MILLIS_PER_MINUTE;

    public static final long MILLIS_PER_DAY = 24 * MILLIS_PER_HOUR;

    public static final int[] MONTH_LENGTH = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static final String yyyyMMddSimple = "yyyyMMdd";
    public static final String yyyyMMdd = "yyyy-MM-dd";
    public static final String yyyyMM = "yyyy-MM";
    public static final String yyyyMMddSTANDARD = "yyyy年MM月dd日";
    public static final String yyyyMMddHH24 = "yyyy-MM-dd HH:mm:ss";
    public static final String yyyyMMddSlash = "yyyy/MM/dd";
    public static final String yyyyMMddHH24Slash = "yyyy/MM/dd HH:mm:ss";
    public static final String timestamp = "yyyyMMddHHmmss";
    public static final String CST = "EEE MMM dd HH:mm:ss zzz yyyy";


    private static final SimpleDateFormat formatYMD = new SimpleDateFormat(yyyyMMddSlash);
    private static final SimpleDateFormat formatYMD24 = new SimpleDateFormat(yyyyMMddHH24Slash);

    private static final SimpleDateFormat formatYMDSimple = new SimpleDateFormat(yyyyMMddSimple);
    private static final SimpleDateFormat formatYMDStd = new SimpleDateFormat(yyyyMMdd);
    private static final SimpleDateFormat formatYMD24Std = new SimpleDateFormat(yyyyMMddHH24);
    private static final SimpleDateFormat formatYMD24Slash = new SimpleDateFormat(yyyyMMddHH24Slash);
    private static final SimpleDateFormat formatTimestamp = new SimpleDateFormat(timestamp);
    private static final SimpleDateFormat formatYMDSlash = new SimpleDateFormat(yyyyMMddSlash);
    private static final SimpleDateFormat formatCST = new SimpleDateFormat(CST, Locale.US);

    private static Map<String, SimpleDateFormat> formats = new HashMap<String, SimpleDateFormat>();

    static {
        formats.put(yyyyMMddSimple, formatYMDSimple);
        formats.put(yyyyMMdd, formatYMDStd);
        formats.put(yyyyMMddHH24, formatYMD24Std);
        formats.put(yyyyMMddHH24Slash, formatYMD24Slash);
        formats.put(yyyyMMddSlash, formatYMDSlash);
        formats.put(CST, formatCST);
    }

    /**
     * 当前时间
     *
     * @return
     */
    public static Date now() {
        return new Date();
    }

    /**
     * 日期字符串转日期, 支持格式:yyyy-MM-dd, yyyy-MM-dd HH:mm:ss, yyyy/MM/dd, yyyy/MM/dd HH:mm:ss
     *
     * @param dateStr
     * @return Date
     */
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
            String pattern = yyyyMMdd;
            if (dateStr.contains("CST")) {
                pattern = CST;
            } else if (dateStr.contains(":")) {
                if (dateStr.contains("-")) {
                    pattern = yyyyMMddHH24;
                } else {
                    pattern = yyyyMMddHH24Slash;
                }
            } else if (dateStr.contains("/")) {
                pattern = yyyyMMddSlash;
            } else if (dateStr.length() == 8) { // yyyyMMdd
                if (dateStr.contains("-")) {
                    pattern = yyyyMMdd;
                } else {
                    pattern = yyyyMMddSimple;
                }

            }
            sdf = new SimpleDateFormat(pattern);
            if(CST.equals(pattern)){
                sdf = new SimpleDateFormat(pattern, Locale.US);
            }
            date = sdf.parse(dateStr, new ParsePosition(0));
        }

        return date;
    }

    /**
     * 日期字符串转化为日期类型
     *
     * @param dateStr
     * @param pattern
     * @return Date
     */
    public static Date str2Date(String dateStr, String pattern) {

        if (!StringUtils.isEmpty(dateStr)) {
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            return dateFormat.parse(dateStr, new ParsePosition(0));
        } else {
            return null;
        }
    }

    /**
     * 日期转字符串(yyyyMMddHHmmss)
     *
     * @param date
     * @return String
     */
    public static String date2timestamp(Date date) {
        String dateStr = null;
        if (date != null) {
            SimpleDateFormat timestampFormat = new SimpleDateFormat(timestamp);
            dateStr = timestampFormat.format(date);
        }
        return dateStr;
    }

    public static String date2timestamp() {
        return date2timestamp(now());
    }

    /**
     * 日期转字符串(yyyy/MM/dd)
     *
     * @param date
     * @return String
     */
    public static String date2Str(Date date) {
        String dateStr = null;
        if (date != null) {
            SimpleDateFormat ymdFormat = new SimpleDateFormat(yyyyMMddSlash);
            dateStr = ymdFormat.format(date);
        }
        return dateStr;
    }

    /**
     * 日期转字符串(yyyy-MM)
     *
     * @param date
     * @return String
     */
    public static String date2StrYM(Date date) {
        String dateStr = null;
        if (date != null) {
            dateStr = date2Str(date, yyyyMM);
        }
        return dateStr;
    }

    /**
     * 日期转字符串(yyyy年MM月dd日)
     *
     * @param date
     * @return String
     */
    public static String date2StrStandard(Date date) {
        String dateStr = null;
        if (date != null) {
            dateStr = date2Str(date, yyyyMMddSTANDARD);
        }
        return dateStr;
    }

    /**
     * 日期转字符串(yyyyMMdd, eg: 20180418)
     *
     * @param date 日期
     * @return
     */
    public static String date2StrSimple(Date date) {
        String dateStr = null;
        if (date != null) {
            dateStr = date2Str(date, yyyyMMddSimple);
        }
        return dateStr;
    }

    /**
     * 日期转字符串(yyyy/MM/dd HH:mm:ss)
     *
     * @param date
     * @return String
     */
    public static String date2Str24H(Date date) {
        String dateStr = null;
        if (date != null) {
            SimpleDateFormat ymd24Format = new SimpleDateFormat(yyyyMMddHH24Slash);
            dateStr = ymd24Format.format(date);
        }
        return dateStr;
    }

    /**
     * 日期转字符串
     *
     * @param date
     * @param pattern
     * @return String
     */
    public static String date2Str(Date date, String pattern) {
        String dateStr = null;
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            dateStr = sdf.format(date);
        }
        return dateStr;
    }

    /**
     * 获取当天零点
     *
     * @param date
     * @return
     */
    public static Date dayBegin(Date date) {
        date = DateUtils.setMilliseconds(date, 0);
        date = DateUtils.setHours(date, 0);
        date = DateUtils.setMinutes(date, 0);
        date = DateUtils.setSeconds(date, 0);
        return date;
    }

    /**
     * 获取当天23:59:59
     *
     * @param date
     * @return
     */
    public static Date dayEnd(Date date) {
        date = DateUtils.setHours(date, 23);
        date = DateUtils.setMinutes(date, 59);
        date = DateUtils.setSeconds(date, 59);
        return date;
    }

    /**
     * 获取日期间相差的天数
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return 时间差(天)
     */
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

        long days = (time2 - time1) / MILLIS_PER_DAY;

        return NumberUtils.toInt(String.valueOf(days));
    }

    /**
     * 获取日期间相差的月数
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return 时间差(月)
     */
    public static int monthsBetween(Date startDate, Date endDate) {

        Validate.notNull(startDate);
        Validate.notNull(endDate);

        Calendar calendarFrom = Calendar.getInstance();
        calendarFrom.setTime(startDate);
        Calendar calendarTo = Calendar.getInstance();
        calendarTo.setTime(endDate);

        return (calendarTo.get(Calendar.YEAR) - calendarFrom.get(Calendar.YEAR)) * 12 + calendarTo.get(Calendar.MONTH) - calendarFrom.get(Calendar.MONTH);
    }

    /**
     * 判断日期是否在范围内，包含相等的日期
     */
    public static boolean isBetween(final Date date, final Date start, final Date end) {
        if (date == null || start == null || end == null || start.after(end)) {
            throw new IllegalArgumentException("some time parameters is null or dateBein after dateEnd");
        }
        return !date.before(start) && !date.after(end);
    }

    /**
     * 是否闰年.
     */
    public static boolean isLeapYear(final Date date) {
        return isLeapYear(get(date, Calendar.YEAR));
    }

    /**
     * 是否闰年，移植Jodd Core的TimeUtil
     * <p>
     * 参数是公元计数, 如2016
     */
    public static boolean isLeapYear(int y) {
        boolean result = false;

        if (((y % 4) == 0) && // must be divisible by 4...
                ((y < 1582) || // and either before reform year...
                        ((y % 100) != 0) || // or not a century...
                        ((y % 400) == 0))) { // or a multiple of 400...
            result = true; // for leap year.
        }
        return result;
    }

    /**
     * 是否同一天.
     *
     * @see DateUtils#isSameDay(Date, Date)
     */
    public static boolean isSameDay(final Date date1, final Date date2) {
        return DateUtils.isSameDay(date1, date2);
    }

    /**
     * 是否同一时刻.
     */
    public static boolean isSameTime(final Date date1, final Date date2) {
        // time.getMillisOf() 比date.getTime()快
        return date1.compareTo(date2) == 0;
    }

    /**
     * 获取某个月有多少天, 考虑闰年等因数, 移植Jodd Core的TimeUtil
     */
    public static int getMonthLength(int year, int month) {

        if ((month < 1) || (month > 12)) {
            throw new IllegalArgumentException("Invalid month: " + month);
        }
        if (month == 2) {
            return isLeapYear(year) ? 29 : 28;
        }

        return MONTH_LENGTH[month];
    }

    /**
     * 获取某个月有多少天, 考虑闰年等因数, 移植Jodd Core的TimeUtil
     */
    public static int getMonthLength(final Date date) {
        int year = get(date, Calendar.YEAR);
        int month = get(date, Calendar.MONTH);
        return getMonthLength(year, month + 1);
    }

    /**
     * 获取某天所属月份的第一天
     */
    public static Date getFirstDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取某天所属月份的最后一天(已考虑闰年二月)
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, getMonthLength(date));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取年份
     *
     * @param date 日期
     * @return
     */
    public static int getYear(Date date) {
        return get(date, Calendar.YEAR);
    }

    /**
     * 获取年份
     *
     * @param dateStr 日期
     * @return
     */
    public static int getYear(String dateStr) {
        return getYear(str2Date(dateStr));
    }

    /**
     * 获取月份
     *
     * @param date 日期
     * @return
     */
    public static int getMonth(Date date) {
        return get(date, Calendar.MONTH) + 1;
    }

    /**
     * 获取月份
     *
     * @param dateStr 日期
     * @return
     */
    public static int getMonth(String dateStr) {
        return getMonth(str2Date(dateStr));
    }

    /**
     * 获取天数
     *
     * @param date 日期
     * @return
     */
    public static int getDay(Date date) {
        return get(date, Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取天数
     *
     * @param dateStr 日期
     * @return
     */
    public static int getDay(String dateStr) {
        return getDay(str2Date(dateStr));
    }

    private static int get(final Date date, int field) {
        Validate.notNull(date, "time");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(field);
    }

    //////////// 往前往后滚动时间//////////////

    /**
     * 加一月
     */
    public static Date addMonths(final Date date, int amount) {
        return DateUtils.addMonths(date, amount);
    }

    /**
     * 减一月
     */
    public static Date subMonths(final Date date, int amount) {
        return DateUtils.addMonths(date, -amount);
    }

    /**
     * 加一周
     */
    public static Date addWeeks(final Date date, int amount) {
        return DateUtils.addWeeks(date, amount);
    }

    /**
     * 减一周
     */
    public static Date subWeeks(final Date date, int amount) {
        return DateUtils.addWeeks(date, -amount);
    }

    /**
     * 加一天
     */
    public static Date addDays(final Date date, final int amount) {
        return DateUtils.addDays(date, amount);
    }

    /**
     * 减一天
     */
    public static Date subDays(final Date date, int amount) {
        return DateUtils.addDays(date, -amount);
    }

    /**
     * 加一个小时
     */
    public static Date addHours(final Date date, int amount) {
        return DateUtils.addHours(date, amount);
    }

    /**
     * 减一个小时
     */
    public static Date subHours(final Date date, int amount) {
        return DateUtils.addHours(date, -amount);
    }

    /**
     * 加一分钟
     */
    public static Date addMinutes(final Date date, int amount) {
        return DateUtils.addMinutes(date, amount);
    }

    /**
     * 加一分钟
     */
    public static Date subMinutes(final Date date, int amount) {
        return DateUtils.addMinutes(date, -amount);
    }

    /**
     * 加一秒.
     */
    public static Date addSeconds(final Date date, int amount) {
        return DateUtils.addSeconds(date, amount);
    }

    /**
     * 减一秒.
     */
    public static Date subSeconds(final Date date, int amount) {
        return DateUtils.addSeconds(date, -amount);
    }

    /**
     * 打印用户友好的，与当前时间相比的时间差，如刚刚，5分钟前，今天XXX，昨天XXX
     * <p>
     * from AndroidUtilCode
     */
    public static String formatFriendlyTime(long timeStampMillis) {
        long now = System.currentTimeMillis();
        long span = now - timeStampMillis;
        if (span < 0) {
            // 'c' 日期和时间，被格式化为 "%ta %tb %td %tT %tZ %tY"，例如 "Sun Jul 20 16:17:00 EDT 1969"。
            return String.format("%tc", timeStampMillis);
        }
        if (span <MILLIS_PER_SECOND) {
            return "刚刚";
        } else if (span <MILLIS_PER_MINUTE) {
            return String.format("%d秒前", span /MILLIS_PER_SECOND);
        } else if (span <MILLIS_PER_HOUR) {
            return String.format("%d分钟前", span /MILLIS_PER_MINUTE);
        }
        // 获取当天00:00
        long wee = DateUtils.truncate(new Date(now), Calendar.DATE).getTime();
        if (timeStampMillis >= wee) {
            // 'R' 24 小时制的时间，被格式化为 "%tH:%tM"
            return String.format("今天%tR", timeStampMillis);
        } else if (timeStampMillis >= wee -MILLIS_PER_DAY) {
            return String.format("昨天%tR", timeStampMillis);
        } else {
            // 'F' ISO 8601 格式的完整日期，被格式化为 "%tY-%tm-%td"。
            return String.format("%tF", timeStampMillis);
        }
    }

    /**
     * 打印用户友好的，与当前时间相比的时间差，如刚刚，5分钟前，今天XXX，昨天XXX
     * <p>
     * from AndroidUtilCode
     */
    public static String formatFriendlyTime(Date date) {
        Validate.notNull(date);
        return formatFriendlyTime(date.getTime());
    }

    /***
     * 获取当前时间的 小时
     */
    public static int getNowHours() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /***
     * 获取当前时间的 分钟
     */
    public static int getNowMinutes() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MINUTE);
    }

    /***
     * 获取当前时间的 秒数
     */
    public static int getNowSeconds() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.SECOND);
    }

    /**
     * 为日期添加当前时分秒, 适用于某天 yyyyMMdd 00:00:00格式日期初始化当前时分秒
     *
     * @return
     */
    public static Date addTime(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        date.setHours(calendar.get(Calendar.HOUR_OF_DAY));
        date.setMinutes(calendar.get(Calendar.MINUTE));
        date.setSeconds(calendar.get(Calendar.SECOND));
        return date;
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
    /**
     * 将String类型转换为datetime类型
     * @param dateTimeStr
     * @param format
     * @return
     */
    public static DateTime getDateTime(String dateTimeStr, String format){
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(format);
        DateTime dateTime = DateTime.parse(dateTimeStr,dateTimeFormatter);
        return dateTime;
    }
}
