package com.winterbe.java8.samples.myTest.Date;

import java.time.*;

/**
 * 计算时间和日期差的工具类
 */
public class TestSub {

    /**
     * 计算两个时间之间的差额（针对 LocalTime 和 LocalDateTime） Duration
     */
    public static void testDuration() {
        /* 在 LocalTime 上使用 */
        LocalTime localTime1 = LocalTime.of(23, 23, 23);
        LocalTime localTime2 = LocalTime.of(20, 20, 20);
        Duration duration = Duration.between(localTime2, localTime1);
        System.out.println(duration.getSeconds()); // 获取两者之间差的秒数，后一个参数减去前一个参数

        /* 在 LocalDate 上使用 */
//        LocalDate localDate1 = LocalDate.of(2023, 2, 2);
//        LocalDate localDate2 = LocalDate.of(2023, 2, 1);
//        Duration duration2 = Duration.between(localDate1, localDate2); // 不支持 LocalDate
//        System.out.println(duration2.getSeconds());

        /* 在 LocalDateTime 上使用 */
        LocalDateTime localDateTime1 = LocalDateTime.of(2023, 2, 2, 23, 23, 23);
        LocalDateTime localDateTime2 = LocalDateTime.of(2023, 2, 1, 20, 20, 20);
        Duration duration3 = Duration.between(localDateTime1, localDateTime2); // 对于 LocalDateTime 可以使用 Duration 来计算相差的秒数
        System.out.println(duration3.getSeconds()); // 获取秒上的差额
        System.out.println(duration3.toHours()); // 获取小时上的差额
        System.out.println(duration3.toDays()); // 获取天数上的差额
    }

    /**
     * 计算两个日期之间的差额 Period
     */
    public static void testPeriod() {
        /* 在 LocalTime 上使用（不能使用） */
        LocalTime localTime1 = LocalTime.of(23, 23, 23);
        LocalTime localTime2 = LocalTime.of(20, 23, 23);
//        Period period = Period.between(localTime2, localTime1); // 不能在 LocalTime 上使用

        /* 在 LocalDate 上使用 */
        LocalDate LocalDate1 = LocalDate.of(2023, 3, 23);
        LocalDate LocalDate2 = LocalDate.of(2022, 1, 23);
        Period between = Period.between(LocalDate2, LocalDate1);
        between.getDays(); // 计算日期差额
        between.getMonths(); // 计算月份差额
        between.getYears(); // 计算年份差额

        /* 在 LocalDateTime 上使用（不能使用） */
        LocalDateTime localDateTime1 = LocalDateTime.of(2023, 3, 23, 23, 23, 23);
        LocalDateTime localDateTime2 = LocalDateTime.of(2022, 1, 23, 20, 23, 23);
//        Period between2 = Period.between(localDateTime2, localDateTime1);
    }

    public static void main(String[] args) {
        testDuration();
        testPeriod();
    }
}
