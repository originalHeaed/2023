package com.winterbe.java8.samples.myTest.Date;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * 测试带时区的日期时间对象
 */
public class TestZoneDate {
    public static void main(String[] args) {
        /* 使用默认时区创建一个时区的日期时间对象 */
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        /* 使用指定的时区创建一个对象 */
        System.out.println(ZonedDateTime.now(ZoneId.of("Asia/Tokyo"))); // 输出 2023-08-08T18:01:25.376+09:00[Asia/Tokyo]
        /* 获取时区 */
        System.out.println(zonedDateTime.getZone());
        /* 其他部分与 LocalDateTime 一致 */
    }
}
