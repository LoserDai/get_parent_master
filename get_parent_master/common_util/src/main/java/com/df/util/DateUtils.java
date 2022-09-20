package com.df.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Author feng.dai
 * @package com.df.util
 * @project get_parent_master
 * @Date 2022/9/19 9:49
 */
public class DateUtils {
    public static final SimpleDateFormat simpleDateFormat_S = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat simpleDateFormat_S2 = new SimpleDateFormat("yyyy-MM-dd/HH:mm:ss");
    public static final SimpleDateFormat simpleDateFormat_D = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat simpleDataFormatNum = new SimpleDateFormat("yyMMddHHmmss");
    public static final SimpleDateFormat simpleDataFormatYY = new SimpleDateFormat("yyyy");

    /**
     * 取得间隔天数.
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getDaysBetween(Date startDate, Date endDate) {
        Calendar fromCalendar = Calendar.getInstance();
        fromCalendar.setTime(startDate);
        fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
        fromCalendar.set(Calendar.MINUTE, 0);
        fromCalendar.set(Calendar.SECOND, 0);
        fromCalendar.set(Calendar.MILLISECOND, 0);

        Calendar toCalendar = Calendar.getInstance();
        toCalendar.setTime(endDate);
        toCalendar.set(Calendar.HOUR_OF_DAY, 0);
        toCalendar.set(Calendar.MINUTE, 0);
        toCalendar.set(Calendar.SECOND, 0);
        toCalendar.set(Calendar.MILLISECOND, 0);

        return (int) (Math.abs(toCalendar.getTime().getTime() - fromCalendar.getTime().getTime())
                / (1000 * 60 * 60 * 24));
    }

    /**
     * 将字符串转换成日期.
     *
     * @param date
     * @return
     */
    public static Date convertStr2Date(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = null;
        try {
            d = sdf.parse(date);
        } catch (Exception e) {
            try {
                d = sdf.parse("1900-01-01");
            } catch (ParseException e1) {
            }
        }
        return d;
    }

    /**
     * 取得数字的字符表示.
     *
     * @param number
     * @return
     */
    public static String getStringNumber(int number) {
        if (number <= 0 || number > 9) {
            return Integer.toString(number);
        }
        String[] nums = {"一", "二", "三", "四", "五", "六", "七", "八", "九"};
        return nums[number - 1];
    }

    /**
     * 日期增加天数.
     *
     * @param date
     * @param day
     * @return
     */
    @SuppressWarnings("static-access")
    public static Date addDay(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(calendar.DATE, day);
        return calendar.getTime();
    }

    /**
     * 日期增加/减少月数.
     *
     * @param date
     * @param month
     * @return
     */
    @SuppressWarnings("static-access")
    public static Date addMonth(Date date, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(calendar.MONTH, month);
        return calendar.getTime();
    }

    /**
     * 日期加秒数.
     *
     * @param date
     * @param second
     * @return
     */
    @SuppressWarnings("static-access")
    public static Date addSecond(Date date, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(calendar.SECOND, second);
        return calendar.getTime();
    }

    /**
     * 转换为日期.
     *
     * @param dateSrc
     * @param fmt
     * @return
     */
    public static Date parseDate(String dateSrc, String fmt) {
        if (null == dateSrc || "".equals(dateSrc)) {
            return null;
        }

        if (null == fmt || "".equals(fmt)) {
            fmt = "yyyy-MM-dd";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        try {
            return sdf.parse(dateSrc);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 转换为日期.
     *
     * @param dateSrc 日期字符串
     * @return 日期
     */
    public static Date parseDate(String dateSrc) {
        return DateUtils.parseDate(dateSrc, null);
    }

    /**
     * 取得日期的星期.
     *
     * @param date 日期
     * @return 中文周名称
     */
    public static String getWeekOfDate(Date date) {
        String[] weekDaysName = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;

        return weekDaysName[intWeek];
    }

    /**
     * 取得当前日期是周几.
     *
     * @param date
     * @return
     */
    public static int getWeekDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 将时间戳转换为时间
     *
     * @param s
     * @return
     */
    public static String stampToDate(String s) {
        String res;
        if (s.length() < 13) {
            int num = 13 - s.length();
            for (int i = 0; i < num; i++) {
                s += "0";
            }
        }
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat_S.format(date);
        return res;
    }


    /**
     * 获取两个日期之间的所有日期
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static List<String> getDays(String startTime, String endTime) {
        // 返回的日期集合
        List<String> days = new ArrayList<String>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date start = dateFormat.parse(startTime);
            Date end = dateFormat.parse(endTime);
            Calendar tempStart = Calendar.getInstance();
            tempStart.setTime(start);
            Calendar tempEnd = Calendar.getInstance();
            tempEnd.setTime(end);
            tempEnd.add(Calendar.DATE, +1);// 日期加1(包含结束)
            while (tempStart.before(tempEnd)) {
                days.add(dateFormat.format(tempStart.getTime()));
                tempStart.add(Calendar.DAY_OF_YEAR, 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return days;
    }

    /**
     * 获取近期的12个月
     *
     * @param Num 距今几个月的前12个月
     * @return
     */
    public static String[] getMonths(int Num) {
        String[] months = new String[12];
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - Num);
        // 加一行代码,否则3月重复
        cal.set(Calendar.DATE, 1);
        for (int i = 0; i < 12; i++) {
            months[11 - i] = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1);
            cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
        }
        return months;
    }
}
