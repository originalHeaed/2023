package com.winterbe.java8.samples.myTest.Date;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 * 测试日期、时间、日期时间格式化类
 */
public class TestDateTimeFormatter {
    /**
     * 时间格式化
     */
    public static void testTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).withLocale(Locale.CHINA);
        /* （将指定的字符串格式化转为 LocalTime 对象）使用格式化器创建一个 LocalTime 对象 */
        LocalTime parse = LocalTime.parse("23:23:23", dateTimeFormatter);
        System.out.println(parse);
        /* （将 LocalTime 格式化之后转为字符串）将时间格式化输出 */
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("时HH-分mm-秒ss");
        System.out.println(parse.format(dateTimeFormatter1)); // 输出
    }

    public static void testDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.CHINA);
        /* （将指定的字符串格式化转为 LocalDate 对象）使用格式化器创建一个 LocalDate 对象 */
        LocalDate parse = LocalDate.parse("2023-03-03", dateTimeFormatter);
        System.out.println(parse);
        /* （将 LocalDate 格式化之后转为字符串）将日期格式化输出 */
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("年YYYY,月MM,日DD");
        System.out.println(parse.format(dateTimeFormatter1));
    }

    public static void main(String[] args) {
        testTime();
        testDate();
        /* LocalDateTime 也一样 */
    }
}
