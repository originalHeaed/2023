package com.winterbe.java8.samples.myTest.Date;

import java.time.Instant;
import java.util.Date;

/**
 * 测试 Instant
 */
public class TestInstant {
    public static void main(String[] args) {
        /* 获取当前时间的瞬时时间戳 */
        Instant instant = Instant.now();
        System.out.println(instant.toString());
        /* 将时间戳转为 jdk1.8 之前的时间类 */
        Date from = Date.from(instant);
    }
}
