package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author feng.dai
 * @Date 2022/8/26 17:20
 * @Version 1.0
 */
public class DateUtil {

    /**
     * 取得间隔天数
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

        return (int) (Math.abs(toCalendar.getTime().getTime() - fromCalendar.getTime().getTime()) / (1000 * 60 * 60 * 24));
    }


    /**
     * 字符串转换成日期
     * @param date
     * @return
     */
    public static Date convertStr2Date(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = null;
        try {
            d = sdf.parse(date);
        } catch(Exception e) {
            try {
                d = sdf.parse("1900-01-01");
            } catch (ParseException e1) {
            }
        }
        return d;
    }


    /**
     * 取得数字的字符表示
     * @param number
     * @return
     */
    public static String getStringNumber(int number){
        if(number <=0 || number > 9) {
            return Integer.toString(number);
        }

        String[] nums = {"一", "二", "三", "四", "五", "六", "七", "八", "九"};

        return nums[number - 1];
    }

    /**
     * 日期增加天数
     * @param date
     * @param day
     * @return
     */
    @SuppressWarnings("static-access")
    public static Date addDay(Date date, int day){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.add(calendar.DATE, day);

        return calendar.getTime();
    }

    /**
     * 日期增加秒数
     * @param date
     * @param second
     * @return
     */
    @SuppressWarnings("static-access")
    public static Date addSecond(Date date, int second){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.add(calendar.SECOND, second);

        return calendar.getTime();
    }

    /**
     * 转换日期
     * @param dateSrc
     * @param fmt
     * @return
     */
    public static Date parseDate(String dateSrc, String fmt) {
        if(null == dateSrc || "".equals(dateSrc)) {
            return null;
        }

        if(null == fmt || "".equals(fmt)) {
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
     * 转换日期
     * @param dateSrc
     * @return
     */
    public static Date parseDate(String dateSrc) {
        return DateUtil.parseDate(dateSrc, null);
    }

    /**
     * 取得日期的星期
     * @param date
     * @return
     */
    public static String getWeekOfDate(Date date) {
        String[] weekDaysName = { "周日", "周一", "周二", "周三", "周四", "周五", "周六" };
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;

        return weekDaysName[intWeek];
    }

    /**
     *取得当前日期是周几
     * @param date
     * @return
     */
    public static int getWeekDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar.get(Calendar.DAY_OF_WEEK);
    }
}
