//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hbasesoft.xiu.xing.util;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class DateUtil {
    private static final int ONE_DAY_MILISECOND = 86400000;

    public static Date string2Date(String dateStr) {
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        } else {
            dateStr = dateStr.trim();
            Date date = null;
            switch(dateStr.length()) {
            case 8:
                date = string2Date(dateStr, "yyyyMMdd");
                break;
            case 9:
            case 12:
            case 13:
            case 15:
            case 16:
            case 18:
            case 20:
            case 22:
            default:
                throw new IllegalArgumentException(dateStr + "不支持的时间格式");
            case 10:
                date = string2Date(dateStr, dateStr.indexOf("/") == -1 ? "yyyy-MM-dd" : "yyyy/MM/dd");
                break;
            case 11:
                date = string2Date(dateStr, "yyyy年MM月dd日");
                break;
            case 14:
                date = string2Date(dateStr, "yyyyMMddHHmmss");
                break;
            case 17:
                date = string2Date(dateStr, "yyyyMMddHHmmssSSS");
                break;
            case 19:
                date = string2Date(dateStr, dateStr.indexOf("/") == -1 ? "yyyy-MM-dd HH:mm:ss" : "yyyy/MM/dd HH:mm:ss");
                break;
            case 21:
                date = string2Date(dateStr, "yyyy年MM月dd日 HH时mm分ss秒");
                break;
            case 23:
                date = string2Date(dateStr, dateStr.indexOf("/") == -1 ? "yyyy-MM-dd HH:mm:ss.SSS" : "yyyy/MM/dd HH:mm:ss.SSS");
            }

            return date;
        }
    }

    public static Date string2Date(String date, String format) {
        if (StringUtils.isEmpty(format)) {
            throw new IllegalArgumentException("the date format string is null!");
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat(format);

            try {
                return sdf.parse(date.trim());
            } catch (ParseException var4) {
                throw new IllegalArgumentException("the date string " + date + " is not matching format: " + format, var4);
            }
        }
    }

    public static String date2String(Date date) {
        return date2String(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String date2String(Date date, String format) {
        String result = null;
        if (date != null) {
            DateFormat sdf = new SimpleDateFormat(format);
            result = sdf.format(date);
        }

        return result;
    }

    public static String getCurrentTimestamp() {
        return date2String(getCurrentDate(), "yyyyMMddHHmmss");
    }

    public static long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public static Date getCurrentDate() {
        return new Date();
    }

    public static int daysBetween(Date startDate) {
        return daysBetween(startDate, getCurrentDate());
    }

    public static Date getYrMonthLastDay(Date d) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(2, 1);
        Date nextMonthFirstDay = getYrMonthFirstDay(calendar.getTime());
        calendar.setTime(nextMonthFirstDay);
        calendar.add(5, -1);
        return calendar.getTime();
    }

    public static Date getYrMonthFirstDay(Date d) {
        String yrMonth = date2String(d, "yyyyMM");
        String date = yrMonth + "01";
        return string2Date(date);
    }

    public static int daysBetween(Date startDate, Date endDate) {
        long s1 = startDate.getTime();
        long s2 = endDate.getTime();
        long c = s1 - s2;
        if (c <= 86400000L) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            int d1 = calendar.get(6);
            calendar.setTime(endDate);
            int d2 = calendar.get(6);
            return d1 == d2 ? 0 : 1;
        } else {
            return Math.abs((new Double(Math.floor((double)((s2 - s1) / 86400000L)))).intValue());
        }
    }

    private DateUtil() {
    }
}
