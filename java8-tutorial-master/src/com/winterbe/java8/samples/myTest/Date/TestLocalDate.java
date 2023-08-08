package com.winterbe.java8.samples.myTest.Date;

import java.time.*;

/**
 * 测试 LocalTime、LocalDate、LocalDateTime
 */
public class TestLocalDate {
    /**
     * 测试本地时间类对象（时间不涉及时区）
     * 注意类似与 String 是一个不可变类
     */
    public static void testLocalTime() {
        /* 使用默认时区创建一个本地时间 */
        LocalTime localTime = LocalTime.now();
        System.out.println(LocalTime.of(23, 23, 23)); // 获取默认时区的当前时间
        /* 获取指定时区的当前时间（不涉及时区） */
        System.out.println(LocalTime.now(Clock.system(ZoneId.of("America/New_York")))); // 获取美国纽约当前时间
        System.out.println(LocalTime.now(ZoneId.of("America/New_York"))); // 获取美国纽约当前时间
        /* 获取相关数据 */
        localTime.getHour();// 获取时
        localTime.getMinute();// 获取分
        localTime.getSecond();// 获取秒
        localTime.getNano();// 获取纳秒
        /* 进行比较 */
        boolean after = localTime.isAfter(LocalTime.of(23, 23, 23));
    }

    /**
     * 测试本地日期（时间上不涉及时区）
     * 注意类似与 String 是一个不可变类
     */
    public static void testLocalDate() {
        /* 使用默认时区，创建 LocalDate 对象 */
        LocalDate localDate = LocalDate.now();
        System.out.println(LocalDate.of(2023, 1, 23)); // 2023-01-23
        /* 创建指定时区的本地日期 */
        System.out.println(LocalDate.now(ZoneId.of("Asia/Tokyo"))); // 获取东京的当前时间
        /* 获取数据 */
        localDate.getYear(); // 获取年份
        localDate.getMonth(); // 获取月份
        System.out.println(localDate.getDayOfYear()); // 获取本年的第几天
        localDate.getDayOfMonth(); // 获取该月的某天
        System.out.println(localDate.getDayOfWeek()); // 获取周几
        /* 对日期进行更改（注意会创建新的 LocalDate 对象） */
        localDate.plusDays(-1); // 加天
        localDate.plusMonths(1); // 加月
        localDate.plusWeeks(2); // 加周
        localDate.plusYears(2); // 加年
        /* 根据当前日期修改年份、月份、天数，然后返回一个新的日期 */
        localDate.withMonth(2); // 将当前日期的月份调整为 2 月，并返回新的 localDate 对象
        localDate.withYear(2021); // 将当前日期的年份调整为 2021 年，并返回新的 localDate 对象
    }

    /**
     * 测试 LocalDateTime
     */
    public static void testLocalDateTime() {
        /* 使用默认时区来创建本地日期时间 */
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(LocalDateTime.of(2023, 8, 8, 23, 23, 23));
        /* 创建指定时区的本地日期时间 */
        System.out.println(LocalDateTime.now(ZoneId.of("Asia/Tokyo"))); // 输出
        /* 获取相关内容 */
//        localDateTime.get... 结合上面的 LocalTime、LocalDateTime
        /* 根据当前值进行加减 */
//        localDateTime.plus...() 在当前的基础上增加指定值，可以为负值（则为减了）
//        localDateTime.minus...() 在当前的基础上减少指定值，可以为负值（则为加了）
        /* 根据当前值直接调整月份、年份、天数等 */
//        localDateTime.with...()
    }



    public static void main(String[] args) {
        testLocalTime();
        testLocalDate();
        testLocalDateTime();
    }
}
