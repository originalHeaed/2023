package com.winterbe.java8.samples.myTest.testLamdba;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestLamdba {
    /**
     * 在 jDK 1.8 之前调用 Collections.sort 方法
     */
    public static void testNormal() {
        List<String> list = Arrays.asList("test1", "test5", "test4", "test6");
        /* 使用匿名内部类的形式 */
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    }

    /**
     * 使用 lamdba 表达式
     */
    public static void testLamdba1() {
        List<String> list = Arrays.asList("test1", "test5", "test4", "test6");
        /* 使用 lamdba 表达式 */
        Collections.sort(list, (ele1, ele2) -> ele1.compareTo(ele2));
    }
}
