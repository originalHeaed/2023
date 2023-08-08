package com.winterbe.java8.samples.myTest.Date;

import java.time.ZoneId;
import java.util.Arrays;

/**
 * 测试时区类 ZoneId
 */
public class TestTimeZone {
    public static void main(String[] args) {
        /* 获取可以使用的时区 ID */
        String[] availableIDs = ZoneId.getAvailableZoneIds().toArray(new String[0]);
        System.out.println(Arrays.toString(availableIDs));
        /* 根据时区 ID 创建时区对象 */
        ZoneId zoneId = ZoneId.of("Asia/Chongqing");
        System.out.println(zoneId.getRules()); // 获取当前时区与标准时间的偏移
    }
}
