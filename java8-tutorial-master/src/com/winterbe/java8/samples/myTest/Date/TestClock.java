package com.winterbe.java8.samples.myTest.Date;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

/**
 * 测试 Clock 类
 */
public class TestClock {
    public static void main(String[] args) {
        /* 获取默认时区的 Clock 对象 */
        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock.getZone()); // 获取时区
        System.out.println(clock.millis()); // 获取当前时间到 unix epoch 的毫秒数
        Instant instant = clock.instant(); // 获取获取一个时间戳类

        /* 使用指定的时区获取一个 Clock 类 */
        Clock system = Clock.system(ZoneId.of("Asia/Shanghai"));
    }
}
